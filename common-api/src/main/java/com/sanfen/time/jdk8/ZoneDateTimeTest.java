package com.sanfen.time.jdk8;

import java.time.ZonedDateTime;

/**
 * ZoneDateTime类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 11:37
 */
public class ZoneDateTimeTest {

    public static void main(String[] args) {
        ZonedDateTime now = ZonedDateTime.now();
        System.out.println(now);
    }

}
