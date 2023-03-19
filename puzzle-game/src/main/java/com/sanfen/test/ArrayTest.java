package com.sanfen.test;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 20:51
 */
public class ArrayTest {
    public static void main(String[] args) {
        int[][] arr = {{14, 6, 11, 7}, {13, 3, 10, 12}, {4, 2, 9, 8}, {0, 15, 5, 1}};
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
        System.out.println(arr[0][1]);
        arr[0][1] = arr[1][1];
        arr[1][1] = 0;
        System.out.println(arr[0][1]);
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j < 4; j++) {
                System.out.print(arr[i][j] + "\t");
            }
            System.out.println();
        }
    }
}
