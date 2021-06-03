package com.github.dttimes.simplejeex.coc.core.base.param;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-03 15:11<p>
 *
 * @author 王輝
 */
public class PagingParam {
    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;

    /**
     * 当前页
     */
    protected long current = 1;

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public long getCurrent() {
        return current;
    }

    public void setCurrent(long current) {
        this.current = current;
    }
}
