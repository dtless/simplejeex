package com.github.dttimes.simplejeex.lang.base;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.MapperFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalTimeDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateTimeSerializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalTimeSerializer;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;

/**
 * JSON工具类,基于Jackson
 *
 * <p><b>slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 10:31<p>
 *
 * @author 王辉
 */
public class JSONs {
    public static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        /**
         * 序列化时不显示null字段
         */
        objectMapper.disable(SerializationFeature.FAIL_ON_EMPTY_BEANS);
        /**
         * 输出正常的时间,而非时间戳
         */
        objectMapper.disable(SerializationFeature.WRITE_DATE_KEYS_AS_TIMESTAMPS);

        /**
         * 反序列化时忽略未知的属性
         */
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        objectMapper.configure(MapperFeature.PROPAGATE_TRANSIENT_MARKER, true);


        /*----------------------------------------------------------
         * 注册Module
         */
        SimpleModule module = new SimpleModule();
        module.addSerializer(LocalDateTime.class, new LocalDateTimeSerializer(DateTimeFormatter.ofPattern(Times.FORMAT_DATETIME)));
        module.addDeserializer(LocalDateTime.class, new LocalDateTimeDeserializer(DateTimeFormatter.ofPattern(Times.FORMAT_DATETIME)));
        module.addSerializer(LocalDate.class, new LocalDateSerializer(DateTimeFormatter.ofPattern(Times.FORMAT_DATE)));
        module.addDeserializer(LocalDate.class, new LocalDateDeserializer(DateTimeFormatter.ofPattern(Times.FORMAT_DATE)));
        module.addSerializer(LocalTime.class, new LocalTimeSerializer(DateTimeFormatter.ofPattern(Times.FORMAT_TIME)));
        module.addDeserializer(LocalTime.class, new LocalTimeDeserializer(DateTimeFormatter.ofPattern(Times.FORMAT_TIME)));
        module.addSerializer(Long.class, ToStringSerializer.instance);
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.registerModule(module);
    }

    /**
     * 返回原生的ObjectMapper对象，以备不满足封装的情况下使用
     *
     * @return
     */
    public static final ObjectMapper objectMapper() {
        return objectMapper;
    }

    public static final String string(Object object) {
        return string(object, false);

    }

    public static final String stringBeautify(Object object) {
        return string(object, true);
    }

    public static final String string(Object object, boolean beautify) {
        if (Objects.isNull(object)) {
            return null;
        } else if (Strings.isCharSequence(object)) {
            return String.valueOf(object);
        } else {
            try {
                return beautify ? objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object)
                        : objectMapper().writeValueAsString(object);
            } catch (JsonProcessingException e) {
                throw new RuntimeException(e);
            }
        }
    }
}