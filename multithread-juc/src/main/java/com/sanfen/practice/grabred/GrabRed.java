package com.sanfen.practice.grabred;

/**
 * 抢红包
 * 假设：100块，分成了3个包，现在有5个人抢
 * 其中，红包是共享数据，5个人是5条线程
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 13:40
 */
public class GrabRed implements Runnable {

    private double money = 100;

    private int count = 3;

    private final double min = 0.01;

    @Override
    public void run() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (GrabRed.class) {
            // 红包已经抢完
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "没抢到");
            } else {
                double prize;
                // 最后一个红包
                if (count == 1){
                    prize = money;
                } else {
                    double bounds = money - (count - 1) * min;
                    // 随机出来红包小于最小值，取最小值
                    prize = Math.max(Math.random() * bounds, min);
                }
                // 减去本次抽到的红包金额和个数
                money -= prize;
                count--;
                System.out.println(Thread.currentThread().getName() + "抢到了" + prize + "元");
            }
        }
    }

}
