package com.sanfen.time.jdk8;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 12:32
 */
public class ChronoUnitTest {

    public static void main(String[] args) {
        LocalDateTime time1 = LocalDateTime.of(2000, 1, 1, 0, 0);
        LocalDateTime time2 = LocalDateTime.of(2023, 1, 1, 0, 0);
        System.out.println(ChronoUnit.YEARS.between(time1, time2));
        System.out.println(ChronoUnit.MONTHS.between(time1, time2));
        System.out.println(ChronoUnit.DAYS.between(time1, time2));
        System.out.println(ChronoUnit.HOURS.between(time1, time2));
        System.out.println(ChronoUnit.MINUTES.between(time1, time2));
        System.out.println(ChronoUnit.SECONDS.between(time1, time2));
    }

}
