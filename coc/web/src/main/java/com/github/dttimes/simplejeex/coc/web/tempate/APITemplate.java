package com.github.dttimes.simplejeex.coc.web.tempate;

import com.github.dttimes.simplejeex.coc.core.constants.Ex;
import com.github.dttimes.simplejeex.coc.core.exception.BizException;
import com.github.dttimes.simplejeex.coc.web.R;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 前端API返回模板方法
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-05-31 22:30<p>
 *
 * @author 王辉
 */
public abstract class APITemplate<T> {
    protected Logger log = LoggerFactory.getLogger(getClass());
    /**
     * 执行时间阈值，用于简单诊断API耗时(10秒)
     */
    public static final long TIME_THRESHOLD = 10000L;

    /**
     * 接口执行前参数校验
     *
     * @throws IllegalArgumentException 参数校验异常
     */
    protected abstract void checkParams() throws IllegalArgumentException;

    /**
     * 业务方法执行入口,业务执行异常时抛出BizException
     *
     * @return 业务返回结果
     * @throws BizException 业务执行异常
     */
    protected abstract T process() throws BizException;


    /**
     * 后置处理器
     */
    public void afterExecute() {

    }

    /**
     * 业务执行成功之后的处理器
     *
     * @param data 业务返回数据
     */
    public void onSuccess(T data) {

    }

    /**
     * 业务执行异常时回调
     *
     * @param e 业务执行异常
     */
    public void onError(Throwable e) {
        if (log.isErrorEnabled()) {
            log.error("API Error while execute", e);
        }
    }

    public R<T> execute() {
        R r = R.ok();
        try {
            this.checkParams();
        } catch (IllegalArgumentException e) {
            if (log.isWarnEnabled()) {
                log.warn("API Params check fail.", e);
            }
            r = R.fail(Ex.ILLEGAL_ARGUMENT, e.getMessage());
        }
        long sTime = System.currentTimeMillis();
        try {
            T ret = this.process();
            this.onSuccess(ret);
            r = R.ok(ret);
        } catch (BizException e) {
            onError(e);
            r = R.fail(e.getMessage());
        } catch (Throwable e) {
            onError(e);
            if (e instanceof RuntimeException) {
                throw (RuntimeException) e;
            } else {
                throw new RuntimeException(e);
            }
        } finally {
            afterExecute();
            long costTime = System.currentTimeMillis() - sTime;
            if (costTime > TIME_THRESHOLD) {
                if (log.isWarnEnabled()) {
                    log.warn("API execute cost too long time, pls optimize it: {} ms", costTime);
                }
            }
            r.space(String.valueOf(costTime));
        }
        return r;
    }
 }
