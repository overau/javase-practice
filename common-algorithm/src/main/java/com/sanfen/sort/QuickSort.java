package com.sanfen.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Random;

/**
 * 快速排序
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 21:25
 */
public class QuickSort {

    public static void main(String[] args) {
        /*
        快速排序：
            第一轮：以0索引的数字为基准数，确定基准数在数组中正确的位置。
            比基准数小的全部在左边，比基准数大的全部在右边。
            后面以此类推。
        */

        //int[] arr = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
        int[] arr = new int[100000];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = new Random().nextInt();
        }

        long start = System.currentTimeMillis();
        quickSort(arr, 0, arr.length - 1);
        long end = System.currentTimeMillis();
        System.out.println("快速排序耗时: " + (end - start));
    }

    public static void quickSort(int[] arr, int i, int j) {
        // 查找的范围
        int start = i;
        int end = j;

        // 递归终止条件
        if (start > end){
            return;
        }

        // 基准数
        int baseNum = arr[i];

        while (start != end) {
            // 利用end从后往前比基准数小的数字
            while (end > start && arr[end] >= baseNum) {
                end--;
            }
            // 利用start从后往前比基准数大的数字
            while (end > start && arr[start] <= baseNum) {
                start++;
            }
            // 把end和start指向的元素交换
            ArrayUtil.swap(arr, start, end);
        }
        // end和start指向同一个元素
        // 已经找到了基准数在数组中应存入的位置
        // 基准数归位
        ArrayUtil.swap(arr, i, start);

        // 确定基准数左边的范围，重复排序
        quickSort(arr, i, start - 1);
        // 确定基准数右边的范围，重复排序
        quickSort(arr, start + 1, j);
    }

}
