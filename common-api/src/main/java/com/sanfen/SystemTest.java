package com.sanfen;

import java.util.Arrays;

/**
 * System类
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 11:45
 */
public class SystemTest {

    public static void main(String[] args) {
        // 获取当前时间: 1679459492591 1679459504494
        long time = System.currentTimeMillis();
        System.out.println(time);

        int[] srcArr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int[] destArr = new int[srcArr.length];
        // 数组拷贝
        System.arraycopy(srcArr, 0, destArr, 4, 3);
        System.out.println(Arrays.toString(srcArr));
        System.out.println(Arrays.toString(destArr));
        // 退出当前虚拟机
        System.exit(1);
        System.out.println("看看我执行了吗?");
    }

}
