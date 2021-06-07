package com.github.dttimes.simplejeex.security.autoconfigure.util;

import com.github.dttimes.simplejeex.coc.web.R;
import com.github.dttimes.simplejeex.lang.base.Charsets;
import com.github.dttimes.simplejeex.lang.base.JSONs;
import com.github.dttimes.simplejeex.lang.base.Webs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-04 16:52<p>
 *
 * @author 王輝
 */
public class SecurityUtils {
    private static final Logger log = LoggerFactory.getLogger(SecurityUtils.class);

    public static void sendError(HttpServletResponse response, HttpStatus status, String message) {
        send(response, status, message);
    }

    public static void sendOk(HttpServletResponse response, String message) {
        send(response, HttpStatus.OK, message);
    }

    private static void send(HttpServletResponse response, HttpStatus status, String message) {
        Objects.requireNonNull(response);
        Objects.requireNonNull(status);
        Objects.requireNonNull(message);

        if (response.isCommitted()) {
            if (log.isWarnEnabled()) {
                log.warn("response is already be committed.");
            }
        }
        response.setCharacterEncoding(Charsets.UTF8);
        response.setContentType(Webs.CONTENT_TYPE_JSON_UTF8);
        try {
            response.setStatus(status.value());
            response.getWriter().write(JSONs.string(R.fail(message)));
            response.flushBuffer();
        } catch (IOException e) {
            if (log.isErrorEnabled()) {
                log.error("http response flush Fail", e);
            }
        }
    }
}