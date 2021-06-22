package com.github.dttimes.simplejeex.lang.ds;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-10 16:01<p>
 *
 * @author 王輝
 */
public class Pair<L, R> {
    private L left;
    private R right;

    public static final <L, R> Pair<L, R> with(L left, R right) {
        return new Pair<>(left, right);
    }

    public Pair(L left, R right) {
        this.left = left;
        this.right = right;
    }

    public Pair<L, R> left(L left) {
        this.left = left;
        return this;
    }

    public L left() {
        return this.left;
    }

    public Pair<L, R> right(R right) {
        this.right = right;
        return this;
    }

    public R right() {
        return this.right;
    }

}
