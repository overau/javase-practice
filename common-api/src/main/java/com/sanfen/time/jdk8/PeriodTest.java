package com.sanfen.time.jdk8;

import java.time.LocalDate;
import java.time.Period;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 12:21
 */
public class PeriodTest {

    public static void main(String[] args) {
        Period period = Period.between(LocalDate.of(2000, 1, 1),
                LocalDate.now());
        System.out.println("时间间隔对象: " + period);
        System.out.println(period.getYears());
        System.out.println(period.getMonths());
        System.out.println(period.getDays());

        System.out.println("===================================");
        System.out.println(period.toTotalMonths());
    }

}
