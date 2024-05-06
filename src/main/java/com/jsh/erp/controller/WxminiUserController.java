package com.jsh.erp.controller;

import cn.hutool.core.util.RandomUtil;
import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.datasource.dto.LoginFormDTO;
import com.jsh.erp.datasource.dto.WXAuth;
import com.jsh.erp.exception.BusinessRunTimeException;
import com.jsh.erp.exception.JshException;
import com.jsh.erp.service.weminiUser.WxminiUserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.RedisConstants;
import com.jsh.erp.utils.RegexUtils;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.sms.v20210111.models.SendSmsResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/weChat")
@Api(tags = {"微信小程序用户管理"})
public class WxminiUserController {
    private final Logger logger = LoggerFactory.getLogger(WxminiUserController.class);

    @Resource
    private WxminiUserService wxminiUserService;
    @Resource
    private StringRedisTemplate stringRedisTemplate;

    @ApiOperation(value = "发送短信验证码")
    @PostMapping("/sendMsg")
    public BaseResponseInfo sendMsg(@RequestParam("phoneNumber") String phoneNumber) {
        BaseResponseInfo res = new BaseResponseInfo();
        // 校验手机号
        if (RegexUtils.isPhoneInvalid(phoneNumber)) {
            res.data = "手机号格式错误!";
            return res;
        }
        try {
            //生成验证码
            String smsCode = RandomUtil.randomNumbers(6);
            //保存验证码到redis
            stringRedisTemplate.opsForValue().set(RedisConstants.LOGIN_WXMINIUSER_SSMCODE + phoneNumber, smsCode, RedisConstants.LOGIN_WXMINIUSER_SSMCODE_TTL, TimeUnit.MINUTES);

            SendSmsResponse response = wxminiUserService.sendSms(phoneNumber, smsCode);
            // 校验是否发送成功
            if ("Ok".equals(response.getSendStatusSet()[0].getCode())) {
                res.code = 200;
                res.data = "短信发送成功!";
            } else {
                logger.error(response.getSendStatusSet()[0].getMessage());
                throw new BusinessRunTimeException(ExceptionConstants.USER_LOGIN_PHONE_NUMBER_SMS_HAS_REACHED_THE_LIMIT_CODE, ExceptionConstants.USER_LOGIN_PHONE_NUMBER_SMS_HAS_REACHED_THE_LIMIT_MSG);
            }
        } catch (TencentCloudSDKException e) {
            JshException.readFail(logger, e);
        }
        return res;
    }

    @ApiOperation(value = "短信验证码登录")
    @PostMapping("/login")
    public BaseResponseInfo login(@RequestBody LoginFormDTO loginFormDTO) {
        BaseResponseInfo res = new BaseResponseInfo();

        try {
            String token = wxminiUserService.login(loginFormDTO);
            res.code = 200;
            res.data = token;
        } catch (BusinessRunTimeException e) {
            res.code = e.getCode(); // 获取自定义错误码
            res.data = e.getData(); // 获取自定义错误描述
        } catch (Exception e) {
            res.code = 500; // Internal Server Error
            res.data = e.getMessage();
        }
        return res;
    }


    @ApiOperation(value = "获取微信sessionId")
    @GetMapping("/sessionId/{code}")
    public String getSessionId(@PathVariable("code") String code) {
        return wxminiUserService.getSessionId(code);
    }

    @ApiOperation(value = "微信授权登录")
    @PostMapping("/authLogin")
    public String authLogin(@RequestBody WXAuth wxAuth) {
        return wxminiUserService.authLogin(wxAuth);
    }

    @ApiOperation(value = "根据手机号查询用户信息")
    @GetMapping("/getUserInfoByPhone")
    public BaseResponseInfo getUserInfoByPhone(@RequestParam String phone) {
        return wxminiUserService.getUserInfoByPhone(phone);
    }

    @ApiOperation(value = "获取邀请子账户二维码")
    @GetMapping("/getWxQRCode")
    public BaseResponseInfo getWxQRCode(String supplierId, String envVersion) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            String accessToken = wxminiUserService.getAccessToken();
            String wxQRCode = wxminiUserService.getWxQRCode(accessToken, supplierId, envVersion);
            res.code = 200;
            res.data = wxQRCode;
        } catch (BusinessRunTimeException e) {
            res.code = e.getCode();
            res.data = e.getData();
        } catch (Exception e) {
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;

    }

    @ApiOperation(value = "获取微信授权手机号")
    @PostMapping("/getPhoneNumber/{accessToken}")
    public BaseResponseInfo getPhoneNumber(@RequestParam String code) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            Object wxQRCode = wxminiUserService.getPhoneNumber(code);
            res.code = 200;
            res.data = wxQRCode;
        } catch (BusinessRunTimeException e) {
            res.code = e.getCode();
            res.data = e.getData();
        } catch (Exception e) {
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;

    }
}

