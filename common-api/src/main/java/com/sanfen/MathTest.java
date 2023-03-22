package com.sanfen;

import java.util.ArrayList;
import java.util.List;

/**
 * Math类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 10:24
 */
public class MathTest {

    public static void main(String[] args) {
        System.out.println(Math.PI);
        System.out.println("============小数取整============");
        System.out.println("12.56向上取整: " + Math.ceil(12.56));
        System.out.println("-12.56向上取整: " + Math.ceil(-12.56));
        System.out.println("12.56向下取整: " + Math.floor(12.56));
        System.out.println("-12.56向下取整: " + Math.floor(-12.56));
        System.out.println("12.56四舍五入取整: " + Math.round(12.56));
        System.out.println("-12.56四舍五入取整: " + Math.round(-12.56));
        System.out.println("============其他常用方法============");
        // Math.abs()如果传入的整数超出范围(-2147483648 ~ 2147483648)，结果不准确
        System.out.println("绝对值: " + Math.abs(-120));
        System.out.println("a的b次幂: " + Math.pow(2, 10));
        System.out.println("a的b次幂: " + Math.pow(4, 0.5));
        System.out.println("a的b次幂: " + Math.pow(4, -2));
        System.out.println("获取两个整数(25, 5)的最大值: " + Math.max(25, 5));
        System.out.println("获取两个整数(25, 5)的最大值: " + Math.min(25, 5));
        System.out.println("========随机数=====================");
        for (int i = 0; i < 10; i++) {
            System.out.println(Math.random());
        }

        System.out.println("997是不是质数? " + isPrime(99999997));
        System.out.println("998是不是质数? " + isPrime(99999998));

        System.out.println("============自幂数==========");
        System.out.println("153是不是自幂数? " + isZiMi(153));

        System.out.println("============自幂数==========");
        System.out.println("独身数: " + getZiMiNum(0, 9));
        System.out.println("没有两位的自幂数: " + getZiMiNum(10, 99));
        System.out.println("水仙花数: " + getZiMiNum(100, 999));
        System.out.println("四叶玫瑰数: " + getZiMiNum(1000, 9999));
        System.out.println("五角星数: " + getZiMiNum(10000, 99999));
        System.out.println("六合数: " + getZiMiNum(100000, 999999));
        System.out.println("北斗七星数: " + getZiMiNum(1000000, 9999999));
        //System.out.println("八仙数: " + getZiMiNum(10000000, 99999999));
        //System.out.println("九九重阳数: " + getZiMiNum(100000000, 999999999));
    }

    /**
     * 判断一个数是否为质数
     * @param number 数字
     * @return 是否为质数
     */
    public static boolean isPrime(int number){
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % 2 == 0){
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个数是不是自幂数: 1^3 + 5^3 + 3^3 = 153
     * @param number 数字
     * @return 是不是自幂数
     */
    public static boolean isZiMi(int number){
        int temp = number;
        int sum = 0;
        int rest;
        while (temp > 0){
            rest = temp % 10;
            sum += Math.pow(rest, getNumberCount(number));
            temp /= 10;
        }
        return sum == number;
    }

    /**
     * 获取整数的位数
     * @param number 整数
     * @return 位数
     */
    public static int getNumberCount(int number){
        int count = 0;
        while (number > 0){
            count++;
            number /= 10;
        }
        return count;
    }

    /**
     * 统计自幂数
     * @return 自幂数的数量
     */
    public static List<Integer> getZiMiNum(int min, int max){
        List<Integer> list = new ArrayList<>();
        for (int i = min; i <= max; i++) {
            if (isZiMi(i)){
                list.add(i);
            }
        }
        return list;
    }

}
