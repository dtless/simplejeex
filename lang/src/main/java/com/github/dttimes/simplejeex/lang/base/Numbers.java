package com.github.dttimes.simplejeex.lang.base;

import com.google.common.base.Strings;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-22 17:01<p>
 *
 * @author 王輝
 */
public class Numbers {

    public static final boolean isInt(String value) {
        if (Strings.isNullOrEmpty(value)) {
            return false;
        }
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            if (i == 0 && ch == '-') {
                continue;
            } else {
                if (!Character.isDigit(ch)) {
                    return false;
                }
            }
        }
        return true;
    }
}
