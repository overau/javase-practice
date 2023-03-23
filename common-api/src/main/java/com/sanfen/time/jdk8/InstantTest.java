package com.sanfen.time.jdk8;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 10:44
 */
public class InstantTest {

    public static void main(String[] args) {
        System.out.println("======================获取现在的时间对象==========================");
        Instant now = Instant.now();
        System.out.println(now);

        System.out.println("======================根据(秒/毫秒/纳秒)获取时间对象===============");
        Instant instant1 = Instant.ofEpochMilli(0L);
        System.out.println(instant1);
        Instant instant2 = Instant.ofEpochSecond(1L);
        System.out.println(instant2);
        Instant instant3 = Instant.ofEpochSecond(1L, 1000000000L);
        System.out.println(instant3);

        System.out.println("======================指定时区==================================");
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.systemDefault());
        System.out.println(zonedDateTime);

        System.out.println("===============================================================");
        Instant instant4 = Instant.ofEpochMilli(0L);
        Instant instant5 = Instant.ofEpochMilli(1000L);
        System.out.println(instant4.isBefore(instant5));
        System.out.println(instant5.isAfter(instant4));

        System.out.println("===============================================================");
        Instant instant6 = Instant.ofEpochMilli(3000L);
        System.out.println(instant6);
        System.out.println(instant6.minusSeconds(10L));
        System.out.println(instant6.plusSeconds(20L));
    }

}
