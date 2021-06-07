package com.github.dttimes.simplejeex.security.autoconfigure.coc.handler;

import com.github.dttimes.simplejeex.security.autoconfigure.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 16:48<p>
 *
 * @author 王輝
 */
public class SxAuthenticationEntryPoint implements AuthenticationEntryPoint {
    private static final Logger log = LoggerFactory.getLogger(SxAuthenticationEntryPoint.class);

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e) {
        if (log.isWarnEnabled()) {
            log.warn("Security authentication entryPoint ==>", e);
        }
        HttpStatus status;
        String message;
        if (e instanceof AuthenticationException) {
            status = HttpStatus.UNAUTHORIZED;
            if (e instanceof LockedException) {
                message = HttpStatus.LOCKED.getReasonPhrase();
            } else if (e instanceof BadCredentialsException) {
                message = HttpStatus.UNAUTHORIZED.getReasonPhrase();
            } else {
                message = e.getMessage();
            }
        } else {
            status = HttpStatus.FORBIDDEN;
            message = HttpStatus.FORBIDDEN.getReasonPhrase();
        }
        SecurityUtils.sendError(response, status, message);
    }
}

