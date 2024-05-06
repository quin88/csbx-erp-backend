package com.jsh.erp.controller;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.internal.OSSHeaders;
import com.aliyun.oss.model.*;
import com.jsh.erp.datasource.entities.SystemConfig;
import com.jsh.erp.service.systemConfig.SystemConfigService;
import com.jsh.erp.service.user.UserService;
import com.jsh.erp.utils.BaseResponseInfo;
import com.jsh.erp.utils.StringUtil;
import com.jsh.erp.utils.Tools;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.HandlerMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

@RestController
@RequestMapping(value = "/systemConfig")
@Api(tags = {"系统参数"})
public class SystemConfigController {
    private Logger logger = LoggerFactory.getLogger(SystemConfigController.class);

    @Resource
    private UserService userService;

    @Resource
    private SystemConfigService systemConfigService;

    @Value(value = "${spring.servlet.multipart.max-file-size}")
    private Long maxFileSize;

    @Value(value = "${spring.servlet.multipart.max-request-size}")
    private Long maxRequestSize;

    @Value("${OSS.ENDPOINT}")
    private String ossEndpoint;

    @Value("${OSS.ACCECCKEYID}")
    private String ossAccessKeyId;

    @Value("${OSS.ACCACCESSKEYSECRET}")
    private String ossAccessKeySecret;

    @Value("${OSS.BUCKETNAME}")
    private String ossBucketName;

    @Value("${DEVELOPMENT.ENVIRONMENT}")
    private String developmentEnvironment;//开发环境

    /**
     * 获取当前租户的配置信息
     *
     * @param request
     * @return
     */
    @GetMapping(value = "/getCurrentInfo")
    @ApiOperation(value = "获取当前租户的配置信息")
    public BaseResponseInfo getCurrentInfo(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            List<SystemConfig> list = systemConfigService.getSystemConfig();
            res.code = 200;
            if (list.size() > 0) {
                res.data = list.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 获取文件大小限制
     *
     * @param request
     * @return
     * @throws Exception
     */
    @GetMapping(value = "/fileSizeLimit")
    @ApiOperation(value = "获取文件大小限制")
    public BaseResponseInfo fileSizeLimit(HttpServletRequest request) throws Exception {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            Long limit = 0L;
            if (maxFileSize < maxRequestSize) {
                limit = maxFileSize;
            } else {
                limit = maxRequestSize;
            }
            res.code = 200;
            res.data = limit;
        } catch (Exception e) {
            e.printStackTrace();
            res.code = 500;
            res.data = "获取数据失败";
        }
        return res;
    }

    /**
     * 文件上传统一方法
     *
     * @param request
     * @param response
     * @return
     */
    @PostMapping(value = "/upload")
    @ApiOperation(value = "文件上传统一方法")
    public BaseResponseInfo upload(HttpServletRequest request, HttpServletResponse response) {
        BaseResponseInfo res = new BaseResponseInfo();
        try {
            String bizPath = request.getParameter("biz");//目录
            MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest) request;
            MultipartFile file = multipartRequest.getFile("file");

            if (StringUtil.isEmpty(bizPath)) {
                bizPath = "";
            }
            String token = request.getHeader("X-Access-Token");
            Long tenantId = Tools.getTenantIdByToken(token);
            bizPath = developmentEnvironment + "/" + bizPath + "/" + tenantId;//拼接租户id
            String ossPath = uploadToOSS(file, bizPath);

            if (StringUtil.isNotEmpty(ossPath)) {
                res.code = 200;
                res.data = ossPath;
            } else {
                res.code = 500;
                res.data = "上传失败！";
            }
        } catch (Exception e) {
            res.code = 500;
            res.data = "上传失败！";
        }
        return res;
    }

    /**
     * 上传文件到阿里云OSS
     *
     * @param file
     * @param bizPath
     * @return
     */
    private String uploadToOSS(MultipartFile file, String bizPath) {
        //构建OSS对象
        OSS ossClient = new OSSClientBuilder().build(ossEndpoint, ossAccessKeyId, ossAccessKeySecret);
        try (InputStream inputStream = file.getInputStream()) {
            String fileName = file.getOriginalFilename();//文件名

            ObjectMetadata objectMetadata = new ObjectMetadata();
            objectMetadata.setContentType(getContentType(fileName.substring(fileName.lastIndexOf("."))));//设置请求头
            objectMetadata.setHeader(OSSHeaders.OSS_STORAGE_CLASS, StorageClass.Standard.toString());
            objectMetadata.setObjectAcl(CannedAccessControlList.Default);//设置类型为默认（私有）

            //拼接目录和文件名
            String url = bizPath + "/" + fileName;
            PutObjectRequest putObjectRequest = new PutObjectRequest(ossBucketName, url, inputStream, objectMetadata);
            ossClient.putObject(putObjectRequest);

            return url;
        } catch (IOException e) {
            return null;
        }
    }

    /**
     * 根据文件扩展名获取对应的 MIME 类型
     */
    public static String getContentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpg";
    }

    /**
     * 预览图片&下载文件
     *
     * @param request
     * @param response
     */
    @GetMapping(value = "/static/**")
    @ApiOperation(value = "预览图片&下载文件")
    public void view(HttpServletRequest request, HttpServletResponse response) {
        // ISO-8859-1 ==> UTF-8 进行编码转换
        String imgPath = extractPathFromPattern(request);
        if (StringUtil.isEmpty(imgPath) || imgPath.equals("null")) {
            return;
        }

        // 构建 OSS 客户端
        OSS ossClient = new OSSClientBuilder().build(ossEndpoint, ossAccessKeyId, ossAccessKeySecret);

        InputStream inputStream = null;
        OutputStream outputStream = null;

        try {
            imgPath = imgPath.replace("..", "");
            if (imgPath.endsWith(",")) {
                imgPath = imgPath.substring(0, imgPath.length() - 1);
            }

            // 从 OSS 中获取文件
            OSSObject ossObject = ossClient.getObject(ossBucketName, imgPath);

            // 设置响应内容类型
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition", "inline;filename=" + new String(imgPath.getBytes("UTF-8"), "ISO-8859-1"));

            inputStream = ossObject.getObjectContent();
            outputStream = response.getOutputStream();
            //转换
            byte[] buf = new byte[1024];
            int len;
            while ((len = inputStream.read(buf)) > 0) {
                outputStream.write(buf, 0, len);
            }
            response.flushBuffer();

        } catch (IOException e) {
            logger.error("预览文件失败" + e.getMessage());
            response.setStatus(404);
            e.printStackTrace();
        } finally {
            if (inputStream != null) {
                try {
                    inputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            if (outputStream != null) {
                try {
                    outputStream.close();
                } catch (IOException e) {
                    logger.error(e.getMessage(), e);
                }
            }
            // 关闭 OSS 客户端
            if (ossClient != null) {
                ossClient.shutdown();
            }
        }
    }

    /**
     * 把指定URL后的字符串全部截断当成参数
     * 这么做是为了防止URL中包含中文或者特殊字符（/等）时，匹配不了的问题
     *
     * @param request
     * @return
     */
    private static String extractPathFromPattern(final HttpServletRequest request) {
        String path = (String) request.getAttribute(HandlerMapping.PATH_WITHIN_HANDLER_MAPPING_ATTRIBUTE);
        String bestMatchPattern = (String) request.getAttribute(HandlerMapping.BEST_MATCHING_PATTERN_ATTRIBUTE);
        return new AntPathMatcher().extractPathWithinPattern(bestMatchPattern, path);
    }
}
