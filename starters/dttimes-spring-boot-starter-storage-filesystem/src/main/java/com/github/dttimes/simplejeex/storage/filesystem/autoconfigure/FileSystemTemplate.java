package com.github.dttimes.simplejeex.storage.filesystem.autoconfigure;

import com.github.dttimes.simplejeex.coc.core.exception.BizException;
import com.github.dttimes.simplejeex.lang.Ak47;
import com.github.dttimes.simplejeex.lang.base.IOs;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 14:53<p>
 *
 * @author 王輝
 */
public class FileSystemTemplate {
    private static final Logger log = LoggerFactory.getLogger(FileSystemTemplate.class);
    @Autowired
    private FileSystemProperties properties;

    public File file(String path) {
        return new File(Ak47.path(properties.getLocalPath(), path));
    }

    public String put(String filename, InputStream is) {
        Objects.requireNonNull(filename);
        Objects.requireNonNull(is);
        String finalName = finalName(filename);

        File file = new File(Ak47.path(properties.getLocalPath(), finalName));
        try (FileOutputStream fos = new FileOutputStream(file)) {
            byte[] buf = new byte[1024 * 8];
            int count;
            while ((count = is.read(buf)) != -1) {
                fos.write(buf, 0, count);
            }
        } catch (IOException e) {
            throw new BizException("IO异常", e);
        } finally {
            IOs.closeQuiet(is);
        }
        return finalName;
    }

    private String finalName(String filename) {
        return String.join("_", String.valueOf(System.currentTimeMillis()), filename);
    }

    public String put(MultipartFile file) {
        Objects.requireNonNull(file);
        String name = finalName(file.getOriginalFilename());
        String path = Ak47.path(properties.getLocalPath(), name);
        if (log.isInfoEnabled()) {
            log.info("store multipartFile to :{}", path);
        }
        try {
            file.transferTo(new File(path));
        } catch (IOException e) {
            throw new BizException("文件存储异常", e);
        }
        return name;
    }

    public String apiPath(String filename) {
        Objects.requireNonNull(filename);
        return Ak47.format("{}/{}", properties.getApiPath(), filename);
    }
}
