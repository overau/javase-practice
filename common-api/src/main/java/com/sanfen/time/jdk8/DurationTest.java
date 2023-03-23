package com.sanfen.time.jdk8;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 12:27
 */
public class DurationTest {

    public static void main(String[] args) {
        Duration duration = Duration.between(LocalDateTime.now(), LocalDateTime.now().plusSeconds(30L));
        System.out.println(duration);
        System.out.println(duration.getSeconds());
        System.out.println(duration.toDays());
        System.out.println(duration.toHours());
        System.out.println(duration.toMinutes());
        System.out.println(duration.toMillis());
        System.out.println(duration.toNanos());
    }

}
