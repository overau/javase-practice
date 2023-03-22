package com.sanfen;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * BigDecimal
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 18:54
 */
public class BigDecimalTest {

    public static void main(String[] args) {
        System.out.println(0.09 + 0.01);
        System.out.println(0.216 - 0.1);
        System.out.println(0.226 * 0.01);
        System.out.println(0.09 / 0.1);

        // 1.传递字符串表示的小数创建对象
        BigDecimal bd1 = new BigDecimal("10.0");
        BigDecimal bd2 = new BigDecimal("3.0");
        BigDecimal bd3 = bd1.add(bd2);
        System.out.println(bd3);
        // 2.静态方法获取对象
        // 如果表示的数字不大，没有超过double的范围，建议使用静态方法
        // 如果超出了double的范围，建议使用构造方法
        BigDecimal bd4 = BigDecimal.valueOf(10);
        System.out.println(bd4);

        System.out.println("================加减乘除===================");
        System.out.println("10.0 + 3.0 = " + bd1.add(bd2));
        System.out.println("10.0 - 3.0 = " + bd1.subtract(bd2));
        System.out.println("10.0 × 3.0 = " + bd1.multiply(bd2));
        System.out.println("10.0 ÷ 3.0 = " + bd1.divide(bd2, 3, RoundingMode.HALF_UP));

        BigDecimal bd5 = new BigDecimal("2147483647.2147483647");
        System.out.println(bd5);
    }

}
