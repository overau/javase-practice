package com.sanfen.wrapclass;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/23 13:00
 */
public class IntegerTest {

    public static void main(String[] args) {
        // 自动装箱、拆箱
        Integer i1 = 5;
        Integer i2 = new Integer("5");
        System.out.println(i1);
        System.out.println(i2);
        // 常用方法
        System.out.println("==================常用方法==================");
        System.out.println("230的二进制表示: " + Integer.toBinaryString(230));
        System.out.println("230的八进制表示: " + Integer.toOctalString(230));
        System.out.println("230的十六进制表示: " + Integer.toHexString(230));
        System.out.println("==========================================");
        int i = Integer.parseInt("123");
        System.out.println(i + 1);
    }

}
