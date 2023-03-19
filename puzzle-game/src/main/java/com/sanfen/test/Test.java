package com.sanfen.test;

import java.util.Arrays;
import java.util.Random;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 15:57
 */
public class Test {

    public static void main(String[] args) {

        //需求: 一维数组中数据0~15，打乱顺序
        //按照4个一组的方式添加到二维数组
        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        Random random = new Random();
        for (int i = 0; i < arr.length; i++) {
            int index = random.nextInt(arr.length);
            int temp = arr[i];
            arr[i] =  arr[index];
            arr[index] =  temp;
        }
        System.out.println(Arrays.toString(arr));
        int[][] data = new int[4][4];
        for (int i = 0; i < arr.length; i++) {
           data[i / 4][i % 4] = arr[i];
        }
        System.out.println(Arrays.deepToString(data));
    }

}
