package com.github.dttimes.simplejeex.security.autoconfigure.coc.filter;

import com.github.dttimes.simplejeex.lang.base.JSONs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-07 10:14<p>
 *
 * @author 王輝
 */
public class SimplejeexUsernamePasswordAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
    private static final Logger log = LoggerFactory.getLogger(SimplejeexUsernamePasswordAuthenticationFilter.class);

    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        if (!request.getMethod().equals("POST")) {
            throw new AuthenticationServiceException("Authentication method not supported: " + request.getMethod());
        } else {
            UsernamePasswordAuthenticationToken authRequest = null;
            try (InputStream ins = request.getInputStream()) {
                Map<String, String> map = JSONs.readValue(ins, Map.class);
                String username = map.getOrDefault("username", "");
                String password = map.getOrDefault("password", "");
                authRequest = new UsernamePasswordAuthenticationToken(username, password);
                this.setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            } catch (IOException e) {
                authRequest = new UsernamePasswordAuthenticationToken("", "");
                if (log.isErrorEnabled()) {
                    log.error("obtain username and password fail.", e);
                }
            } finally {
                setDetails(request, authRequest);
                return this.getAuthenticationManager().authenticate(authRequest);
            }

        }
    }
}