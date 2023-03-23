package com.sanfen.time.jdk7;

import java.util.Calendar;

/**
 * Calendar类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 9:42
 */
public class CalendarTest {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);
        System.out.println(calendar);
        System.out.println(calendar.getTimeInMillis());

        calendar.set(Calendar.YEAR, 2000);

        System.out.println("==============================");
        System.out.println("年: " + calendar.get(Calendar.YEAR));
        System.out.println("月: " + calendar.get(Calendar.MONTH) + 1);
        System.out.println("日: " + calendar.get(Calendar.DAY_OF_MONTH));
        System.out.println(getWeek(calendar.get(Calendar.DAY_OF_WEEK)));
    }

    /**
     * 查表法：数据跟索引产生关系
     * @param index 索引
     * @return 星期几
     */
    public static String getWeek(int index){
        String[] weeks = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        if (index < 0 || index > weeks.length - 1){
            return "";
        }
        return weeks[index];
    }

}
