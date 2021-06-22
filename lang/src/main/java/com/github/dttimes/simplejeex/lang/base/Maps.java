package com.github.dttimes.simplejeex.lang.base;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.function.Supplier;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-22 14:21<p>
 *
 * @author 王輝
 */
public class Maps {
    private Maps() {
    }

    /**
     * 构建一个Map,默认使用HashMap实现
     *
     * @param <K> Map的key类型
     * @param <V> Map的value类型
     * @return 一个MapBuilder对象
     */
    public static <K, V> MapBuilder<K, V> builder() {
        return builder(HashMap::new);
    }

    /**
     * Maps.<String, String>builder(TreeMap::new)
     *
     * @param supplier
     * @param <K>
     * @param <V>
     * @return
     */
    public static <K, V> MapBuilder<K, V> builder(Supplier<Map<K, V>> supplier) {
        return new MapBuilder<>(supplier.get());
    }

    /**
     * 构建一个并发的Map,使用ConcurrentMap实现
     *
     * @param <K> Map的key类型
     * @param <V> Map的value类型
     * @return 一个MapBuilder对象
     */
    public static <K, V> ConcurrentMapBuilder<K, V> concurrentBuilder() {
        return concurrentBuilder(ConcurrentHashMap::new);
    }

    public static <K, V> ConcurrentMapBuilder<K, V> concurrentBuilder(Supplier<ConcurrentMap<K, V>> mapSupplier) {
        return new ConcurrentMapBuilder<>(mapSupplier.get());
    }

    private static class BaseBuilder<M extends Map<K, V>, K, V> {

        protected final M map;

        public BaseBuilder(M map) {
            this.map = map;
        }

        public BaseBuilder<M, K, V> put(K key, V value) {
            map.put(key, value);
            return this;
        }

        public M build() {
            return map;
        }
    }

    public static class MapBuilder<K, V> extends BaseBuilder<Map<K, V>, K, V> {

        private boolean unmodifiable;

        public MapBuilder(Map<K, V> map) {
            super(map);
        }

        @Override
        public MapBuilder<K, V> put(K key, V value) {
            super.put(key, value);
            return this;
        }

        public MapBuilder<K, V> unmodifiable(boolean unmodifiable) {
            this.unmodifiable = unmodifiable;
            return this;
        }

        public MapBuilder<K, V> unmodifiable() {
            return unmodifiable(true);
        }

        @Override
        public Map<K, V> build() {
            if (unmodifiable) {
                return Collections.unmodifiableMap(super.build());
            } else {
                return super.build();
            }
        }
    }

    public static class ConcurrentMapBuilder<K, V> extends BaseBuilder<ConcurrentMap<K, V>, K, V> {

        public ConcurrentMapBuilder(ConcurrentMap<K, V> map) {
            super(map);
        }

        @Override
        public ConcurrentMapBuilder<K, V> put(K key, V value) {
            super.put(key, value);
            return this;
        }
    }
}
