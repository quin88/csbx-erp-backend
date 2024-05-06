package com.jsh.erp.config;

import com.jsh.erp.constants.ExceptionConstants;
import com.jsh.erp.exception.BusinessParamCheckingException;
import com.jsh.erp.service.redis.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Arrays;
import java.util.List;

@Component
public class TokenExpirationInterceptor implements HandlerInterceptor {

    @Autowired
    private RedisService redisService;

    // 配置要跳过 token 过期检查的接口路径列表
    private final List<String> skipTokenCheckPaths = Arrays.asList(
            "/jshERP-boot/weChat/sendMsg",
            "/jshERP-boot/platformConfig/getPlatform/name",
            "/jshERP-boot/platformConfig/getPlatform/url",
            "/jshERP-boot/platformConfig/getPlatform/version",
            "/jshERP-boot/platformConfig/getPlatformConfigByKey",
            "/jshERP-boot/user/login",
            "/jshERP-boot/doc.html",
            "/jshERP-boot/webjars/.*",
            "/jshERP-boot/user/logout",
            "/jshERP-boot/systemConfig/static/.*"
    );

    /*
     * 过滤器，判断是否 token 过期
     * */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        // 判断是否需要跳过 token 过期检查
        if (shouldSkipTokenExpirationCheck(request)) {
            return true;
        }

        Object userIdObject = redisService.getObjectFromSessionByKey(request, "userId");
        if (userIdObject == null) {
            throw new BusinessParamCheckingException(ExceptionConstants.USER_LOGIN_EXPIRED_STATUS_CODE,
                    ExceptionConstants.USER_LOGIN_EXPIRED_STATUS_MSG);
        }
        return true;
    }

    // 判断是否应该跳过 token 过期检查
    private boolean shouldSkipTokenExpirationCheck(HttpServletRequest request) {
        String requestURI = request.getRequestURI();
        for (String path : skipTokenCheckPaths) {
            if (requestURI.matches(path)) {
                return true;
            }
        }
        return false;
    }

}


