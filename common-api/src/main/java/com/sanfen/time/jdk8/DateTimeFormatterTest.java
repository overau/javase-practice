package com.sanfen.time.jdk8;

import java.time.Instant;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

/**
 * DateTimeFormatter
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 11:45
 */
public class DateTimeFormatterTest {

    public static void main(String[] args) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String format = formatter.format(Instant.now().atZone(ZoneId.systemDefault()));
        System.out.println(format);
    }

}
