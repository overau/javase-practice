package com.sanfen.practice.lottery;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 17:15
 */
public class LotteryTest {

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));
        Lottery task = new Lottery(list);

        new Thread(task, "抽奖箱1").start();
        new Thread(task, "抽奖箱2").start();
    }

}
