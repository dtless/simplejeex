package com.github.dttimes.simplejeex.coc.core.convert;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.github.dttimes.simplejeex.coc.core.base.Paging;
import com.github.dttimes.simplejeex.lang.Ak47;
import com.github.dttimes.simplejeex.lang.base.Checks;
import org.springframework.core.convert.converter.Converter;

import java.util.List;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * Bean转换辅助类
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 17:21<p>
 *
 * @author 王輝
 */
public class Converters {

    public static final <S, T> T convert(S source, Class<T> clazz) {
        return convert(source, clazz, null);
    }

    public static final <S, T> T convert(S source, Class<T> clazz, Consumer<T> then) {
        return convert(source, new DefaultBeanCopyConverter<S, T>(clazz), then);
    }

    public static final <S, T> T convert(S source, Converter<S, T> converter) {
        return convert(source, converter, null);
    }

    public static final <S, T> T convert(S source, Converter<S, T> converter, Consumer<T> then) {
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

    public static final <S, T> List<T> convertList(List<S> sourceList, Class<T> clazz) {
        return convertList(sourceList, new DefaultBeanCopyConverter<>(clazz), null);

    }

    public static final <S, T> List<T> convertList(List<S> sourceList, Converter<S, T> converter, Consumer<T> then) {
        Checks.nonNull(converter, "BeanList转换器不能为空");

        return Ak47.defaultList(sourceList)
                .stream()
                .map(source -> convert(source, converter, then))
                .collect(Collectors.toList());
    }
}
