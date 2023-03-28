package com.sanfen.search;

import java.util.ArrayList;
import java.util.List;

/**
 * 基本查找/顺序查找
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 16:58
 */
public class BasicSearch {

    public static void main(String[] args) {
        //需求：定义一个方法利用基本查找，查询某个元素是否存在
        //数据如下：{131, 127, 147, 81, 103, 23, 7, 79}
        int[] arr = {131, 127, 147, 7, 103, 23, 7, 79};
        System.out.println(basicSearch(arr, 20));
        System.out.println(basicSearch(arr, 7));
        // [3, 6]
        System.out.println(basicSearchIndex(arr, 7));
    }

    /**
     * 查找元素在数组中是否存在
     * @param arr 数组
     * @param number 待查找的元素
     * @return 是否存在
     */
    public static boolean basicSearch(int[] arr, int number){
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number){
                return true;
            }
        }
        return false;
    }

    /**
     * 查找元素在数组中的索引，考虑重复元素
     * @param arr 数组
     * @param number 查找元素
     * @return 元素在数组中的索引集合
     */
    public static List<Integer> basicSearchIndex(int[] arr, int number){
        List<Integer> indexList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == number){
                indexList.add(i);
            }
        }
        return indexList;
    }

}
