package com.github.dttimes.simplejeex.lang.base;

import java.io.IOException;
import java.io.InputStream;
import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-09 16:32<p>
 *
 * @author 王輝
 */
public class IOs {
    public static final void closeQuiet(InputStream is) {
        if (Objects.nonNull(is)) {
            try {
                is.close();
            } catch (IOException e) {
            }
        }
    }
}
