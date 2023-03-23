package com.sanfen.time.jdk8;

import java.time.LocalDate;
import java.time.MonthDay;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 12:10
 */
public class LocalDateTest {

    public static void main(String[] args) {
        // 判断今天是不是你的生日
        LocalDate localDate = LocalDate.of(1996, 10, 3);
        LocalDate now = LocalDate.now();
        MonthDay birthMonthDay = MonthDay.of(localDate.getMonth(), localDate.getDayOfMonth());
        MonthDay nowMonthDay = MonthDay.of(now.getMonth(), now.getDayOfMonth());
        if (birthMonthDay.equals(nowMonthDay)){
            System.out.println("今天是你的生日");
        } else {
            System.out.println("今天是你的生日");
        }
    }

}
