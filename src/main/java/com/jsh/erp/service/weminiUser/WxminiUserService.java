package com.jsh.erp.service.weminiUser;

import cn.hutool.core.util.IdUtil;
import cn.hutool.core.util.RandomUtil;
import cn.hutool.http.HttpUtil;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.google.gson.Gson;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.LoginFormDTO;
import com.jsh.erp.datasource.dto.WXAuth;
import com.jsh.erp.datasource.entities.*;
import com.jsh.erp.datasource.mappers.*;
import com.jsh.erp.datasource.vo.UserVo;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.redis.RedisService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.RedisConstants;
import com.jsh.erp.utils.RegexUtils;
import com.jsh.erp.utils.StringUtil;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.sms.v20210111.SmsClient;
import com.tencentcloudapi.sms.v20210111.models.SendSmsRequest;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.security.spec.AlgorithmParameterSpec;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static cn.hutool.core.codec.Base64.decode;

@Service
@Transactional
public class WxminiUserService {
    private final Logger log = LoggerFactory.getLogger(WxminiUserService.class);
    @Value("${TENCENT.SMS.KEYID}")
    private String secretID;
    @Value("${TENCENT.SMS.KEYSECRET}")
    private String secretKey;
    @Value("${TENCENT.SMS.SMSSDKAPPID}")
    private String smsSdkAppID;
    @Value("${TENCENT.SMS.SIGNNAME}")
    private String signName;
    @Value("${TENCENT.SMS.TEMPLATEID}")
    private String templateID;

    @Value("${WXMINI.APPID}")
    private String appId;

    @Value("${WXMINI.SECRET}")
    private String secret;

    @Resource
    public StringRedisTemplate stringRedisTemplate;

    @Resource
    private WxminiUserMapperEx wxminiUserMapperEx;

    @Resource
    private WxminiUserMapper wxminiUserMapper;

    @Resource
    private RedisService redisService;
    @Resource
    private SupplierMapperEx supplierMapperEx;
    @Resource
    private SupplierExtendMapperEx supplierExtendMapperEx;

    /**
     * 发送短信验证码
     *
     * @param phoneNumber
     * @return
     */
    public SendSmsResponse sendSms(String phoneNumber, String smsCode) throws TencentCloudSDKException {
        Credential cred = new Credential(secretID, secretKey);
        // 实例化一个http选项，可选的，没有特殊需求可以跳过
        HttpProfile httpProfile = new HttpProfile();
        httpProfile.setEndpoint("sms.tencentcloudapi.com");
        // 实例化一个client选项，可选的，没有特殊需求可以跳过
        ClientProfile clientProfile = new ClientProfile();
        clientProfile.setHttpProfile(httpProfile);
        // 实例化要请求产品的client对象,clientProfile是可选的
        SmsClient client = new SmsClient(cred, "ap-guangzhou", clientProfile);
        // 实例化一个请求对象,每个接口都会对应一个request对象
        SendSmsRequest req = new SendSmsRequest();
        //设置固定的参数
        req.setSmsSdkAppId(smsSdkAppID);// 短信应用ID: 短信SdkAppId在 [短信控制台] 添加应用后生成的实际SdkAppId
        req.setSignName(signName);//短信签名内容: 使用 UTF-8 编码，必须填写已审核通过的签名
        req.setTemplateId(templateID);//模板 ID: 必须填写已审核通过的模板 ID

        String[] phone = {"+86" + phoneNumber};
        // 发送的手机号
        req.setPhoneNumberSet(phone);
        String[] templateParamSet1 = {smsCode, RedisConstants.LOGIN_WXMINIUSER_SSMCODE_TTL.toString()};
        req.setTemplateParamSet(templateParamSet1);
        // 返回的resp是一个SendSmsResponse的实例，与请求对象对应
        return client.SendSms(req);
    }


    /**
     * 微信小程序用户登录
     *
     * @param loginFormDTO
     * @return
     */
    public String login(LoginFormDTO loginFormDTO) {
        WxminiUser wxminiUser = null;
        //校验手机号
        String phoneNumber = loginFormDTO.getPhoneNumber();
        if (RegexUtils.isPhoneInvalid(phoneNumber)) {
            throw new BusinessRunTimeException(ExceptionConstants.USER_PHONE_IS_INVALID_CODE,
                    String.format(ExceptionConstants.USER_PHONE_IS_INVALID_MSG));
        }
        //2.校验验证码
        String cacheCode = stringRedisTemplate.opsForValue().get(RedisConstants.LOGIN_WXMINIUSER_SSMCODE + phoneNumber);
        String smsCode = loginFormDTO.getSmsCode();
        if (cacheCode == null || !cacheCode.equals(smsCode)) {
            throw new BusinessRunTimeException(ExceptionConstants.USER_VERIFICATION_CODE_ERROR_CODE,
                    String.format(ExceptionConstants.USER_VERIFICATION_CODE_ERROR_MSG));
        }
        //3.验证码一致，根据手机号查用户
        wxminiUser = wxminiUserMapperEx.selectByPhoneNumber(phoneNumber);
        //4.判断用户是否存在
        if (wxminiUser == null) {
            //不存在，则创建用户
            wxminiUser = createWxminiUser(phoneNumber);
        }
        //5.1随机生成token，作为登陆令牌
        String token = buildToken(wxminiUser);
        redisService.storageObjectBySession(token, "userId", wxminiUser.getId());
        //6返回token
        return token;
    }

    /**
     * 创建新用户
     *
     * @param phoneNumber
     * @return
     */
    public WxminiUser createWxminiUser(String phoneNumber) {
        WxminiUser wxminiUser = new WxminiUser();
        wxminiUser.setPhoneNumber(phoneNumber);
        wxminiUser.setAvatarUrl("");
        wxminiUser.setCreateTime(LocalDateTime.now());
        wxminiUser.setUpdateTime(LocalDateTime.now());
        wxminiUser.setNickName(RedisConstants.WXMINIUSER_NICK_NAME_PREFIX + RandomUtil.randomString(10));
        wxminiUserMapper.insertSelective(wxminiUser);
        return wxminiUserMapperEx.selectByPhoneNumber(phoneNumber);
    }

    /**
     * 获取openid和sessionKey
     *
     * @param code
     * @return
     */
    public String getSessionId(String code) {
        if (StringUtil.isEmpty(code)) {
            return "code不能为空";
        }
        String url = "https://api.weixin.qq.com/sns/jscode2session?appid={0}&secret={1}&js_code={2}&grant_type=authorization_code";
        String replaceUrl = url.replace("{0}", appId).replace("{1}", secret).replace("{2}", code);
        String res = HttpUtil.get(replaceUrl);
        log.debug("发送链接后获得的数据:" + res);
        if (JSONObject.parseObject(res).get("errcode") != null) {
            return JSONObject.parseObject(res).get("errmsg").toString();
        }
        String s = IdUtil.simpleUUID();
        stringRedisTemplate.opsForValue().set(RedisConstants.WX_USER_ID + s, res);
        return s;
    }

    /**
     * 微信授权登录操作
     *
     * @param wxAuth
     * @return
     */
    public String authLogin(WXAuth wxAuth) {
        String encryptedData = wxAuth.getEncryptedData();
        String sessionId = wxAuth.getSessionId();
        String iv = wxAuth.getIv();

        String sessionKey = null;
        String openId = null;

        String json = stringRedisTemplate.opsForValue().get(RedisConstants.WX_USER_ID + sessionId);
        if (StringUtil.isEmpty(json)) {
            log.error("json数据查询异常！");
        }
        JSONObject jsonObject = JSON.parseObject(json);
        sessionKey = (String) jsonObject.get("session_key");
        openId = (String) jsonObject.get("openid");
        try {
            //1.数据解密
            String wxRes = wxDecrypt(encryptedData, iv, sessionKey);
            log.debug("解密的用户信息：" + wxRes);
            //2.将json数据转为对象
            WxminiUser wxUserInfo = JSONObject.parseObject(wxRes, WxminiUser.class);
            //3.检查用户是否存在
            WxminiUser wxminiUser = wxminiUserMapperEx.selectByOpenId(openId);
            if (wxminiUser == null) {
                //不存在，则注册用户信息
                wxUserInfo.setIsAuth(true);
                wxUserInfo.setOpenId(openId);
                wxUserInfo.setNickName(RedisConstants.WXMINIUSER_NICK_NAME_PREFIX + RandomUtil.randomNumbers(10));
                wxminiUserMapper.insert(wxUserInfo);
                wxminiUser = wxminiUserMapperEx.selectByOpenId(openId);
            } else {
                wxminiUser.setUpdateTime(LocalDateTime.now());
                wxminiUserMapper.updateByPrimaryKeySelective(wxminiUser);
            }

            String token = buildToken(wxminiUser);
            redisService.storageObjectBySession(token, "userId", wxminiUser.getId());
            return token;

        } catch (Exception e) {
            JshException.readFail(log, e);
            return "登录失败";
        }
    }

    /**
     * 生成token
     *
     * @param wxminiUser
     * @return
     */
    private static String buildToken(WxminiUser wxminiUser) {
        String token = IdUtil.simpleUUID();
        if (wxminiUser.getTenantId() != null) {
            token = token + "_" + wxminiUser.getTenantId();
        }
        return token;
    }

    /**
     * 数据解密
     *
     * @param encryptedData
     * @param iv
     * @param sessionKey
     * @return
     * @throws Exception
     */
    private String wxDecrypt(String encryptedData, String iv, String sessionKey) throws Exception {
        byte[] encData = decode(encryptedData);
        byte[] vi = decode(iv);
        byte[] key = decode(sessionKey);
        AlgorithmParameterSpec ivSpec = new IvParameterSpec(vi);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        SecretKeySpec keySpec = new SecretKeySpec(key, "AES");
        cipher.init(Cipher.DECRYPT_MODE, keySpec, ivSpec);
        return new String(cipher.doFinal(encData), StandardCharsets.UTF_8);
    }

    /**
     * 根据手机号查询当前用户信息，用于微信小程序--手机验证码登录后验证
     *
     * @param phone
     * @return
     */
    public BaseResponseInfo getUserInfoByPhone(String phone) {
        BaseResponseInfo baseResponseInfo = new BaseResponseInfo();

        try {
            //查询供应商表
            List<UserVo> suppliers = supplierMapperEx.getSupplierByPhone(phone);
            //查询子账户表
            List<UserVo> supplierExtends = supplierExtendMapperEx.getSupplierExtendByPhone(phone);

            HashMap<String, Object> map = new HashMap<>();
            map.put("suppliers", suppliers == null ? null : suppliers.stream().map(supplier -> {
                supplier.setRole("主账号");
                return supplier;
            }).collect(Collectors.toList()));

            map.put("supplierExtends", supplierExtends);

            baseResponseInfo.code = 200;
            baseResponseInfo.data = map;
        } catch (Exception e) {
            baseResponseInfo.code = 500;
            baseResponseInfo.data = "获取用户信息异常：" + e.getMessage();
        }
        return baseResponseInfo;
    }

    public String sendWeChatRequest(String endpoint, String method) throws Exception {
        URL url = new URL("https://api.weixin.qq.com/" + endpoint);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod(method);
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        conn.setDoOutput(true);

        if ("POST".equals(method)) {
            String postData = "{\"access_token\":\"" + getAccessToken() + "\"}";
            System.out.println("postData = " + postData);
            byte[] postDataBytes = postData.getBytes("UTF-8");
            conn.getOutputStream().write(postDataBytes);
        }

        try (BufferedReader in = new BufferedReader(new InputStreamReader(conn.getInputStream()))) {
            Gson gson = new Gson();
            String response = gson.toJson(in.lines().collect(Collectors.joining("\n")));
            return response;
        }
    }

    public String getWxQRCode(String accessToken, String supplierId, String envVersion) {
        String PROGRAM_CODE_URL = "https://api.weixin.qq.com/wxa/getwxacodeunlimit?access_token=%s";
        try {
            String url = String.format(PROGRAM_CODE_URL, accessToken);
            RestTemplate rest = new RestTemplate();
            Map<String, Object> param = new HashMap<>();
            // 限制32位
            param.put("scene", "supplierId=" + supplierId + "&t=2");//和供应商绑定
            // 设置路径和宽度
            param.put("env_version", envVersion);
            param.put("page", "pages/nameAuthentication/index");
            param.put("width", 280);
            param.put("auto_color", false);
            MultiValueMap<String, String> headers = new LinkedMultiValueMap<>();
            HttpEntity requestEntity = new HttpEntity(param, headers);
            ResponseEntity<byte[]> entity = rest.exchange(url, HttpMethod.POST, requestEntity, byte[].class, new Object[0]);
            log.info("调用小程序生成微信永久小程序码URL接口返回结果:" + entity.getBody());
            byte[] result = entity.getBody();
            String res = Base64.encodeBase64String(result);
            if (!StringUtils.isEmpty(res)) {//不为空就生成二维码Base64
                String encoded = "data:image/jpg;base64," + res.replaceAll("[\\s*\t\n\r]", "");
                return encoded;
            }
        } catch (Exception e) {
            throw new BusinessRunTimeException(ExceptionConstants.GET_WECHAT_QRCODE_FAILED_CODE,
                    ExceptionConstants.GET_WECHAT_QRCODE_FAILED_MSG);
        }
        return null;
    }

    public String getAccessToken() throws Exception {
        String tokenUrl = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret=" + secret;
        HttpURLConnection conn = (HttpURLConnection) new URL(tokenUrl).openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Content-Type", "application/json");
        conn.setRequestProperty("Accept", "application/json");
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        String result = reader.readLine();
        Gson gson = new Gson();
        Map<String, String> map = gson.fromJson(result, Map.class);
        return map.get("access_token");
    }

    /**
     * 微信登录接口，还没有调试，需要购买微信认证组件进行调试：https://mp.weixin.qq.com/wxamp/wxacharge?lang=zh_CN&token=4485417
     * @param code
     * @return
     * @throws Exception
     */
    public Object getPhoneNumber(String code) throws Exception {
        // 获取token
        String token_url = String.format("https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=%s&secret=%s", appId, secret);
        JSONObject token = JSON.parseObject(HttpUtil.get(token_url));

        // 使用前端code获取手机号码 参数为json格式
        String url = "https://api.weixin.qq.com/wxa/business/getuserphonenumber?access_token=" + token.getString("access_token");
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("code", code);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<Map<String, String>> httpEntity = new HttpEntity<>(paramMap, headers);
        System.out.println(httpEntity);
        // 发送HTTP请求
        ResponseEntity<String> responseEntity = new RestTemplate().postForEntity(url, httpEntity, String.class);
        String responseBody = responseEntity.getBody();

        // 解析JSON响应
        JSONObject responseJson = JSON.parseObject(responseBody);

        // 检查是否存在错误码
        if (responseJson.containsKey("errcode") && responseJson.getInteger("errcode") == 0) {
            // 获取手机号信息
            JSONObject phoneInfo = responseJson.getJSONObject("phone_info");
            if (phoneInfo != null) {
                // 获取purePhoneNumber
                String purePhoneNumber = phoneInfo.getString("purePhoneNumber");
                System.out.println("purePhoneNumber: " + purePhoneNumber);
            }
        }
        return null;
    }
}




