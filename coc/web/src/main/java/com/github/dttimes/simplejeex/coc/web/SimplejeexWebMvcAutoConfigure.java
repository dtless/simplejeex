package com.github.dttimes.simplejeex.coc.web;

import com.github.dttimes.simplejeex.coc.web.conf.WebJacksonConfiguration;
import com.github.dttimes.simplejeex.coc.web.exception.GlobalWebExceptionAdvice;
import com.github.dttimes.simplejeex.lang.base.Hosts;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.web.context.WebServerInitializedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-07 11:15<p>
 *
 * @author 王輝
 */
@ConditionalOnWebApplication
@ImportAutoConfiguration(WebJacksonConfiguration.class)
public class SimplejeexWebMvcAutoConfigure implements ApplicationListener<WebServerInitializedEvent>, WebMvcConfigurer {
    private static final Logger log = LoggerFactory.getLogger(SimplejeexWebMvcAutoConfigure.class);

    private int port = 8080;

    @Bean
    public CommandLineRunner commandLineRunner() {
        return args -> {
            if (log.isInfoEnabled()) {
                log.info("====> 服务已启动,请访问: http://{}:{}", Hosts.hostAddress(), port);
            }
        };
    }

    @Override
    public void onApplicationEvent(WebServerInitializedEvent event) {
        port = event.getWebServer().getPort();
    }

    @Bean
    public GlobalWebExceptionAdvice exceptionAdvice() {
        return new GlobalWebExceptionAdvice();
    }
}
