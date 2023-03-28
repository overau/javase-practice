package com.sanfen.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * 冒泡排序
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 19:21
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        // (0)2 4 3 1 5
        // (1)2 3 1 4 5
        // (2)2 1 3 4 5
        // (3)1 2 3 4 5
        bubbleSort(arr);
    }

    public static void bubbleSort(int[] arr) {
        // 外层循环表示比较的轮次
        for (int i = 0; i < arr.length - 1; i++) {
            // 每一轮的排序过程: 相邻元素比较交换
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    ArrayUtil.swap(arr, j, j + 1);
                }
            }
            System.out.println("第 " + (i + 1) + " 轮排序: " + Arrays.toString(arr));
        }
    }

}
