package com.sanfen;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Random;

/**
 * BigInteger
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 15:23
 */
public class BigIntegerTest {

    public static void main(String[] args) {
        // 1.获取一个随机的大整数
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            BigInteger bi = new BigInteger(4, random);
            //System.out.println(bi);
        }

        // 2.获取一个指定的大整数
        BigInteger bi2 = new BigInteger("999999999999999");
        System.out.println(bi2);

        // 3.获取一个指定进制的大整数
        BigInteger bi3 = new BigInteger("100", 2);
        System.out.println(bi3);

        // 4.静态方法获取一个大整数
        BigInteger bi4 = BigInteger.valueOf(1000);
        System.out.println(bi4);

        // 5.对象一旦创建，内部数字无法修改
        BigInteger bi5 = BigInteger.valueOf(1);
        BigInteger bi6 = BigInteger.valueOf(2);
        BigInteger result = bi5.add(bi6);
        System.out.println(result);

        // 6.加减乘除
        System.out.println("================加减乘除=============");
        BigInteger big1 = BigInteger.valueOf(10);
        BigInteger big2 = BigInteger.valueOf(3);
        // 加
        System.out.println("10 + 2 = " + big1.add(big2));
        // 减
        System.out.println("10 - 2 = " + big1.subtract(big2));
        // 乘
        System.out.println("10 * 2 = " + big1.multiply(big2));
        // 除
        System.out.println("10 ÷ 2 = " + big1.divide(big2));
        // 除
        System.out.println("10 ÷ 2 = " + Arrays.toString(big1.divideAndRemainder(big2)));
        System.out.println("====================================");
        // equals
        System.out.println(big1.equals(bi2));
        // 次幂
        System.out.println("10^3 = " + big1.pow(3));
        // max
        System.out.println("big1(10)和big2(1)最大值: " + big1.max(big2));
        // intValue
        System.out.println(big1.intValue());
    }

}
