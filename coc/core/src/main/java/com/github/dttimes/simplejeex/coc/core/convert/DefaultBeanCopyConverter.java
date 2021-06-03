package com.github.dttimes.simplejeex.coc.core.convert;

import org.springframework.beans.BeanUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-03 16:14<p>
 *
 * @author 王輝
 */
public class DefaultBeanCopyConverter<S, T> implements Converter<S, T> {
    private Class<T> clazz;

    public DefaultBeanCopyConverter(Class<T> clazz) {
        this.clazz = clazz;
    }

    @Override
    public T convert(S s) {
        T target = BeanUtils.instantiateClass(clazz);
        BeanUtils.copyProperties(s, target);
        return target;
    }
}
