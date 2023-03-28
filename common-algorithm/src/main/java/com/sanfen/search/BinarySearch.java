package com.sanfen.search;

/**
 * 二分查找/折半查找
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 17:12
 */
public class BinarySearch {

    public static void main(String[] args) {
        //需求：定义一个方法利用二分查找，查询元素在数组中的索引
        //数据如下：{7, 23, 79, 81, 103, 127, 131, 147}
        int[] arr = {7, 23, 79, 81, 103, 127, 131, 147};
        System.out.println(binarySearch(arr, 127));
        System.out.println(binarySearch(arr, 7));
        System.out.println(binarySearch(arr, 0));
    }

    /**
     * 二分查找查询元素在数组中的索引
     * @param arr 数组(必须有序)
     * @param number 元素
     * @return 元素在数组中的索引
     */
    public static int binarySearch(int[] arr, int number){
        // 左闭右开[min, max)
        int min = 0;
        int max = arr.length;
        while (min < max){
            int middle = min + (max - min) / 2;
            if (number > arr[middle]){
                min = middle + 1;
            } else if (number < arr[middle]) {
                max = middle;
            } else {
                return middle;
            }
        }
        return -1;
    }

}
