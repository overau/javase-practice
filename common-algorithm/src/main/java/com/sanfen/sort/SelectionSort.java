package com.sanfen.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * 选择排序
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 20:16
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 3, 1};
        selectSort(arr);
    }

    public static void selectSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[i] > arr[j]) {
                    ArrayUtil.swap(arr, i, j);
                }
            }
            System.out.println("第 " + (i + 1) + " 轮: " + Arrays.toString(arr));
        }
    }

}
