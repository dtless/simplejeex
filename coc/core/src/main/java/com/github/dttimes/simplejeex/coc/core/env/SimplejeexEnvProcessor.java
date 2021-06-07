package com.github.dttimes.simplejeex.coc.core.env;

import org.springframework.beans.factory.BeanInitializationException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.env.EnvironmentPostProcessor;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.env.MapPropertySource;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PropertiesLoaderUtils;

import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Properties;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-07 12:03<p>
 *
 * @author 王輝
 */
public class SimplejeexEnvProcessor implements EnvironmentPostProcessor, Ordered {
    @Override
    public void postProcessEnvironment(ConfigurableEnvironment environment, SpringApplication application) {
        ClassPathResource resources = new ClassPathResource("simplejeex-env.properties");
        if (resources.exists()) {
            try {
                Properties properties = PropertiesLoaderUtils.loadProperties(resources);
                Map<String, Object> confs = new HashMap<>(properties.size());
                Iterator<Map.Entry<Object, Object>> ltr = properties.entrySet().iterator();
                while (ltr.hasNext()) {
                    Map.Entry<Object, Object> entry = ltr.next();
                    String key = String.valueOf(entry.getKey());
                    if (!environment.containsProperty(key)) {
                        confs.put(key, entry.getValue());
                    } else {
                    }
                }
                PropertySource ps = new MapPropertySource("SIMPLEJEEX-CONFIG", confs);
                environment.getPropertySources().addFirst(ps);
            } catch (IOException e) {
                throw new BeanInitializationException("初始化BootX默认规约失败", e);
            }

        }

    }

    @Override
    public int getOrder() {
        return Ordered.HIGHEST_PRECEDENCE + 999;
    }
}

