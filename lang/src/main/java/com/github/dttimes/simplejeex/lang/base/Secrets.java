package com.github.dttimes.simplejeex.lang.base;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-02 17:45<p>
 *
 * @author 王輝
 */
public class Secrets {

    /**
     * 生成32位小写的md5值
     *
     * @param text
     * @return
     */
    public static final String md5Hex(String text) {
        Checks.hasLen(text);
        return hash("MD5", text);
    }

    /**
     * 进行encode
     *
     * @param algorithm encode算法
     * @param text      待加工的字符串
     * @return
     */
    private static String hash(String algorithm, String text) {
        Objects.requireNonNull(algorithm);
        Objects.requireNonNull(text);
        try {
            MessageDigest md = MessageDigest.getInstance(algorithm);
            byte[] bytes = md.digest(text.getBytes(Charsets.UTF8));
            return hex(bytes);
        } catch (NoSuchAlgorithmException | UnsupportedEncodingException e) {
            throw new RuntimeException("");
        }
    }

    private static String hex(byte[] bytes) {
        StringBuilder sb = new StringBuilder();
        for (byte b : bytes) {
            String hex = Integer.toHexString(b & 0xFF);
            if (hex.length() == 1) {
                sb.append("0");
            }
            sb.append(hex);
        }
        return sb.toString();
    }
}