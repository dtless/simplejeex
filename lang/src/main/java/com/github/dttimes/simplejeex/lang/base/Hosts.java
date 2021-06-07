package com.github.dttimes.simplejeex.lang.base;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <p><b>Slogan: 一生伏首拜阳明</b></p>
 * <p> Create At 2021-06-07 11:20<p>
 *
 * @author 王輝
 */
public class Hosts {
    public String hostname() {
        return local().getHostName();
    }

    public static final String hostAddress() {
        return local().getHostAddress();
    }

    private static InetAddress local() {
        try {
            return InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            throw new RuntimeException("get local host fail", e);
        }
    }
}
