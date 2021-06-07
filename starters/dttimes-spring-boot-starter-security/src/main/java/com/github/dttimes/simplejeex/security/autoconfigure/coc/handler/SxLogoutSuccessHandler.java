package com.github.dttimes.simplejeex.security.autoconfigure.coc.handler;

import com.github.dttimes.simplejeex.security.autoconfigure.util.SecurityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 17:49<p>
 *
 * @author 王輝
 */
public class SxLogoutSuccessHandler implements LogoutSuccessHandler {
    private static final Logger log = LoggerFactory.getLogger(SxLogoutSuccessHandler.class);

    @Override
    public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) {
        if (log.isInfoEnabled()) {
            log.info("Logout ==> {}", authentication);
        }
        SecurityUtils.sendOk(response, "logout success.");
    }
}