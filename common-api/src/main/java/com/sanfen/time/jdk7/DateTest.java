package com.sanfen.time.jdk7;

import java.util.Date;
import java.util.Random;

/**
 * Date
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 21:04
 */
public class DateTest {

    public static void main(String[] args) {
        Date d1 = new Date();
        System.out.println("d1 = " + d1);
        Date d2 = new Date(0L);
        System.out.println(d2);
        d2.setTime(1000L);
        System.out.println(d2);

        long time = d2.getTime();
        System.out.println("time = " + time);

        System.out.println("============================");
        // 时间原点开始1年后的时间
        Date date1 = new Date(0L);
        long time1 = date1.getTime();
        time1 = time1 + 1000L * 365 * 24 * 3600;
        date1.setTime(time1);
        System.out.println(date1);
        // 比较两个Date对象
        System.out.println("==============比较两个Date对象============");
        Random random = new Random();
        Date date2 = new Date(Math.abs(random.nextInt()));
        Date date3= new Date(Math.abs(random.nextInt()));
        System.out.println(date2);
        System.out.println(date3);
        long time2 = date2.getTime();
        long time3 = date3.getTime();
        System.out.println(date2 + " > " + date3 + ": " + (time2 > time3));
    }

}
