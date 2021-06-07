package com.github.dttimes.simplejeex.security.autoconfigure.coc.handler;

import com.github.dttimes.simplejeex.security.autoconfigure.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 17:24<p>
 *
 * @author 王輝
 */
public class SxAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(SxAuthenticationSuccessHandler.class);

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        if (log.isInfoEnabled()) {
            log.info("Login in success. => {}", authentication);
        }
        SecurityUtils.sendOk(response, "login success");
    }
}