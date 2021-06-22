package com.github.dttimes.simplejeex.storage.filesystem.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 14:59<p>
 *
 * @author 王輝
 */
@ConfigurationProperties(prefix = "simplejeex.storage.filesystem", ignoreInvalidFields = true)
public class FileSystemProperties {
    private static final Logger log = LoggerFactory.getLogger(FileSystemProperties.class);
    /**
     * web访问根路径
     */
    private String apiPath = "/api/_storage-filesystem";
    /**
     * 本地存储文件路径
     */
    private String localPath = "~/.simplejeex/storage";

    public String getApiPath() {
        return apiPath;
    }

    public void setApiPath(String apiPath) {
        this.apiPath = apiPath;
    }

    public String getLocalPath() {
        return localPath;
    }

    public void setLocalPath(String localPath) {
        this.localPath = localPath;
    }
}