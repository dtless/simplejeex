package com.github.dttimes.simplejeex.coc.core.base;

import com.github.dttimes.simplejeex.lang.Ak47;

import java.util.Collection;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-03 14:38<p>
 *
 * @author 王輝
 */
public class Paging<T> {
    public Paging() {
        this.total = 0;
        this.current = 1;
        this.size = 10;
        this.records = Ak47.newLinkedList();
    }

    /**
     * 总数
     */
    protected long total = 0;
    /**
     * 每页显示条数，默认 10
     */
    protected long size = 10;

    /**
     * 当前页
     */
    protected long current = 1;
    /**
     * 查询记录
     */
    private Collection<T> records;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

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

    public Collection<T> getRecords() {
        return records;
    }

    public void setRecords(Collection<T> records) {
        this.records = records;
    }
}
