package com.sanfen.sort;

import cn.hutool.core.util.ArrayUtil;

import java.util.Arrays;

/**
 * 插入排序
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 20:36
 */
public class InsertSort {

    public static void main(String[] args) {
         /*
            插入排序：
                将0索引的元素到N索引的元素看做是有序的，把N+1索引的元素到最后一个当成是无序的。
                遍历无序的数据，将遍历到的元素插入有序序列中适当的位置，如遇到相同数据，插在后面。
                N的范围：0~最大索引

        */
        int[] arr = {3, 44, 38, 5, 47, 15, 36, 26, 27, 2, 46, 4, 19, 50, 48};

        // 找到无序数据的开始索引
        int startIndex = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > arr[i + 1]) {
                startIndex = i + 1;
                break;
            }
        }
        // 遍历无序数据得到每一个元素
        for (int i = startIndex; i < arr.length; i++) {
            // 记录当前要插入数据的索引
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                ArrayUtil.swap(arr, j, j - 1);
                j--;
            }
        }

        System.out.println(Arrays.toString(arr));
    }

}
