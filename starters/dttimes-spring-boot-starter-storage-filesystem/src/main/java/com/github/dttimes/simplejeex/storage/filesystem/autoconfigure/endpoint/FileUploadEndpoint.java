package com.github.dttimes.simplejeex.storage.filesystem.autoconfigure.endpoint;

import com.github.dttimes.simplejeex.coc.core.exception.BizException;
import com.github.dttimes.simplejeex.coc.web.R;
import com.github.dttimes.simplejeex.coc.web.tempate.APITemplate;
import com.github.dttimes.simplejeex.lang.base.Checks;
import com.github.dttimes.simplejeex.storage.filesystem.autoconfigure.FileSystemTemplate;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 17:07<p>
 *
 * @author 王輝
 */
@Tag(name = "系统相关")
@RequestMapping("/api/_simplejeex-storage-upload")
public class FileUploadEndpoint {
    @Autowired
    private FileSystemTemplate template;

    @Operation(summary = "上传文件")
    @PostMapping()
    @ResponseBody
    public R<String> upload(@RequestPart("file") MultipartFile file) {
        return new APITemplate<String>() {
            @Override
            protected void checkParams() throws IllegalArgumentException {
                Checks.nonNull(file);
            }

            @Override
            protected String process() throws BizException {
                String path = template.put(file);
                return template.apiPath(path);
            }
        }.execute();
    }
}
