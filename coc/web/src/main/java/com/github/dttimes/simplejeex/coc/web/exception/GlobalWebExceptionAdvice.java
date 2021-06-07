package com.github.dttimes.simplejeex.coc.web.exception;

import com.github.dttimes.simplejeex.coc.core.exception.BizException;
import com.github.dttimes.simplejeex.coc.web.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import javax.servlet.http.HttpServletRequest;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-07 11:03<p>
 *
 * @author 王輝
 */
@RestControllerAdvice
public class GlobalWebExceptionAdvice {
    private static final Logger log = LoggerFactory.getLogger(GlobalWebExceptionAdvice.class);

    @ExceptionHandler(NoHandlerFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public R notFound(HttpServletRequest request, NoHandlerFoundException e) {
        if (log.isWarnEnabled()) {
            log.warn("request path [{}] not found.", request.getRequestURI(), e);
        }
        return R.fail("请求路径不存在").data(String.format("request path not found : " + request.getRequestURI()));
    }

    @ExceptionHandler(BizException.class)
    @ResponseStatus(HttpStatus.OK)
    public R bizException(BizException e) {
        if (log.isWarnEnabled()) {
            log.warn("biz exception.", e);
        }
        return R.fail("业务异常").data(e.getMessage());
    }

    @ExceptionHandler(Throwable.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public R sysException(Throwable e) {
        if (log.isErrorEnabled()) {
            log.error("sys exception", e);
        }
        return R.fail("系统异常").data(e.getMessage());
    }
}







