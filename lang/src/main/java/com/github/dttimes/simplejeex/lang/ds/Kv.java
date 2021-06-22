package com.github.dttimes.simplejeex.lang.ds;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-10 16:06<p>
 *
 * @author 王輝
 */
public class Kv<K, V> {
    private K key;
    private V value;

    public Kv(K key, V value) {
        this.key = key;
        this.value = value;
    }

    public static final <K, V> Kv<K, V> kv(K key, V value) {
        return new Kv(key, value);
    }

    public Kv<K, V> key(K key) {
        this.key = key;
        return this;
    }

    public K key() {
        return this.key;
    }

    public Kv<K, V> value(V value) {
        this.value = value;
        return this;
    }

    public V value() {
        return this.value;
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }
}
