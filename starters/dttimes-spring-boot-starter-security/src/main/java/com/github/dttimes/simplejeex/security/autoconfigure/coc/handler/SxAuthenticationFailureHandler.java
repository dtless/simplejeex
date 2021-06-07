package com.github.dttimes.simplejeex.security.autoconfigure.coc.handler;

import com.github.dttimes.simplejeex.security.autoconfigure.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 17:45<p>
 *
 * @author 王輝
 */
public class SxAuthenticationFailureHandler implements AuthenticationFailureHandler {
    public static final Logger log = LoggerFactory.getLogger(SxAuthenticationFailureHandler.class);

    @Override
    public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        if (log.isWarnEnabled()) {
            log.warn("Login Fail", e);
        }
        SecurityUtils.sendError(response, HttpStatus.OK, "登录失败,帐号或密码错误");
    }
}
