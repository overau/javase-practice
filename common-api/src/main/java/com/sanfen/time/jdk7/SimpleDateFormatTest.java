package com.sanfen.time.jdk7;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * SimpleDateFormat
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 9:00
 */
public class SimpleDateFormatTest {

    public static void main(String[] args) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat();
        Date date = new Date();
        System.out.println(sdf1.format(date));

        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss E");
        System.out.println(sdf2.format(date));

        Date parse = sdf2.parse("2023年03月23日 09:14:07 星期四");
        System.out.println(parse.getTime());

        System.out.println("=====================================");
        SimpleDateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");
        Date date1 = format1.parse("2000-11-11");
        SimpleDateFormat format2 = new SimpleDateFormat("yyyy年MM月dd日");
        System.out.println(format2.format(date1));

        System.out.println("=====================================");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDate = dateFormat.parse("2023年11月11日 0:0:0");
        Date endDate = dateFormat.parse("2023年11月11日 0:10:0");
        Date p1 = dateFormat.parse("2023年11月11日 00:01:00");
        Date p2 = dateFormat.parse("2023年11月11日 00:11:0");
        System.out.println("小贾有没有参与秒杀活动? " +
                (p1.getTime() >= startDate.getTime() && p1.getTime() <= endDate.getTime()));
        System.out.println("小皮有没有参与秒杀活动? " +
                (p2.getTime() >= startDate.getTime() && p2.getTime() <= endDate.getTime()));
    }

}
