package com.github.dttimes.simplejeex.storage.filesystem.autoconfigure;

import com.github.dttimes.simplejeex.lang.Ak47;
import com.github.dttimes.simplejeex.lang.base.JVMs;
import com.github.dttimes.simplejeex.storage.filesystem.autoconfigure.endpoint.FileUploadEndpoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.io.File;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 14:52<p>
 *
 * @author 王輝
 */
@EnableConfigurationProperties(FileSystemProperties.class)
public class FileSystemAutoConfiguration implements InitializingBean {
    private static final Logger log = LoggerFactory.getLogger(FileSystemAutoConfiguration.class);

    private FileSystemProperties fileSystemProperties;

    public FileSystemAutoConfiguration(FileSystemProperties fileSystemProperties) {
        this.fileSystemProperties = fileSystemProperties;
    }

    @ConditionalOnClass(WebMvcConfigurer.class)
    @Bean
    public FileSystemWebConf fileSystemWebConf() {
        return new FileSystemWebConf();
    }

    @Bean
    public FileSystemTemplate fileSystemTemplate() {
        return new FileSystemTemplate();
    }

    @ConditionalOnWebApplication
    @RequestScope
    @Bean
    public FileUploadEndpoint uploadEndpoint() {
        return new FileUploadEndpoint();
    }

    @Override
    public void afterPropertiesSet() {
        if (fileSystemProperties.getLocalPath().startsWith("~")) {
            fileSystemProperties.setLocalPath(Ak47.path(JVMs.userHome(), fileSystemProperties.getLocalPath().substring(1)));
        }

        File local = new File(fileSystemProperties.getLocalPath());
        if (local.isDirectory() && local.exists()) {
            if (log.isInfoEnabled()) {
                log.info("storage file system local directory already exists ==> {}", local.getAbsolutePath());
            }
        } else {
            if (log.isInfoEnabled()) {
                log.info("storage file system local directory mkdirs ==> {]", local.getAbsolutePath());
            }
            local.mkdirs();
        }
        if (log.isInfoEnabled()) {
            log.info("simplejeex storage filesystem local path:{}, api path:{}", fileSystemProperties.getLocalPath(), fileSystemProperties.getApiPath());
        }
    }
}
