package com.sanfen.practice.lottery4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 17:15
 */
public class LotteryTest4 {

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(10, 5, 20, 50, 100, 200, 500, 800, 2, 80, 300, 700));
        Lottery4 callable = new Lottery4(list);

        FutureTask<Integer> futureTask1 = new FutureTask<>(callable);
        FutureTask<Integer> futureTask2 = new FutureTask<>(callable);

        Thread t1 = new Thread(futureTask1, "抽奖箱1");
        t1.start();
        Thread t2 = new Thread(futureTask2, "抽奖箱2");
        t2.start();

        Integer max1 = futureTask1.get();
        Integer max2 = futureTask2.get();
        System.out.println("=====================================================");
        System.out.println("在此次抽奖过程中," + (max1 > max2 ? t1.getName() : t2.getName())
                + "中产生了最大奖项,该奖项金额为" + Math.max(max1, max2) + "元");
    }

}
