package com.github.dttimes.simplejeex.coc.service;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.github.dttimes.simplejeex.coc.core.base.Paging;
import com.github.dttimes.simplejeex.coc.core.base.param.PagingParam;
import com.github.dttimes.simplejeex.coc.core.convert.Converters;
import com.github.dttimes.simplejeex.coc.core.convert.DefaultBeanCopyConverter;
import org.springframework.core.convert.converter.Converter;

import java.util.Objects;
import java.util.function.Consumer;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-03 15:51<p>
 *
 * @author 王輝
 */
public class BaseService<M extends BaseMapper<T>, T> extends ServiceImpl<M, T> implements IService<T> {

    protected <S, T> T convert(S source, Consumer<T> then) {
        return null;
    }

    protected <S, T> T convert(S source, Converter<S, T> converter) {
        return convert(source, converter, null);
    }

    protected <S, T> T convert(S source, Converter<S, T> converter, Consumer<T> then) {
        return Converters.convert(source, converter, then);
    }

    protected <S, T> Paging<T> convert(IPage<S> page, Converter<S, T> converter) {
        return convert(page, converter, null);
    }

    protected <S, T> Paging<T> convert(IPage<S> page, Converter<S, T> converter, Consumer<T> then) {
        if (Objects.isNull(page)) {
            return new Paging<>();
        }
        Paging<T> p = new Paging<>();
        p.setCurrent(page.getCurrent());
        p.setTotal(page.getTotal());
        p.setSize(page.getSize());
        p.setRecords(Converters.convertList(page.getRecords(), converter, then));
        return p;
    }

    protected <S, T> Paging<T> convert(IPage<S> page, Class<T> clazz) {
        return convert(page, clazz, null);
    }

    protected <S, T> Paging<T> convert(IPage<S> page, Class<T> clazz, Consumer<T> then) {
        return convert(page, new DefaultBeanCopyConverter<S, T>(clazz), then);
    }

    protected IPage param(PagingParam param) {
        Page<Object> p = new Page<>();
        p.setCurrent(1);
        p.setSize(10);

        if (Objects.nonNull(param)) {
            p.setCurrent(param.getCurrent());
            p.setSize(param.getSize());
        }
        return p;
    }
}
