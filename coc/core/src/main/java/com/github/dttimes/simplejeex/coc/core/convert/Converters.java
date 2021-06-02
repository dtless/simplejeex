package com.github.dttimes.simplejeex.coc.core.convert;

import com.github.dttimes.simplejeex.lang.base.Checks;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * Bean转换辅助类
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 17:21<p>
 *
 * @author 王輝
 */
public class Converters {

    public static final <S, T> T convert(Converter<S, T> converter, S source) {
        return convert(converter, source, null);
    }

    public static final <S, T> T convert(Converter<S, T> converter, S source, Consumer<T> then) {
        Checks.nonNull(converter, "Bean转换器不能为空");
        if (Objects.isNull(source)) {
            return null;
        }
        T target = converter.convert(source);
        if (Objects.nonNull(then)) {
            then.accept(target);
        }
        return target;
    }

}
