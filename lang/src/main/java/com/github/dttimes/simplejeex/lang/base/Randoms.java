package com.github.dttimes.simplejeex.lang.base;

import java.util.Random;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 15:05<p>
 *
 * @author 王輝
 */
public class Randoms {
    public static final Random RANDOM = new Random();

    public static final String randomString(int length) {
        Checks.positive(length);
        StringBuilder sb = new StringBuilder();
        int count = 0;
        do {
            int value;
            switch (RANDOM.nextInt(3)) {
                case 0:
                    value = Asciis.DIGIT_MIN + RANDOM.nextInt(Asciis.DIGIT_MAX - Asciis.DIGIT_MIN + 1);
                    break;
                case 1:
                    value = Asciis.LOW_LETTER_MIN + RANDOM.nextInt(Asciis.LOW_LETTER_MAX - Asciis.LOW_LETTER_MIN + 1);
                    break;
                default:
                    value = Asciis.UPPER_LETTER_MIN + RANDOM.nextInt(Asciis.UPPER_LETTER_MAX - Asciis.UPPER_LETTER_MIN + 1);
                    break;
            }
            sb.append(Casts.toChar(value));
        } while (count++ < length);
        return sb.toString();
    }
}
