package com.github.dttimes.simplejeex.coc.core.exception;

/**
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 11:34<p>
 *
 * @author 王辉
 */
public class SimpleJeexException extends RuntimeException {
    public SimpleJeexException() {
    }

    public SimpleJeexException(String message) {
        super(message);
    }

    public SimpleJeexException(String message, Throwable cause) {
        super(message, cause);
    }
}
