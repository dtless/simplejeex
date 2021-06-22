package com.github.dttimes.simplejeex.coc.web.conf;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.dttimes.simplejeex.lang.base.JSONs;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-11 16:00<p>
 *
 * @author 王輝
 */

@Configuration
public class WebJacksonConfiguration {
    @ConditionalOnMissingBean(ObjectMapper.class)
    @Primary
    @Bean
    public ObjectMapper objectMapper() {
        return JSONs.objectMapper();
    }
}
