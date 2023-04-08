package com.sanfen.practice.grabred;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * 抢红包
 * 假设：100块，分成了3个包，现在有5个人抢
 * 其中，红包是共享数据，5个人是5条线程
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 13:40
 */
public class GrabRed2 implements Runnable {

    private BigDecimal money = BigDecimal.valueOf(100.0);

    private int count = 3;

    private final BigDecimal min = BigDecimal.valueOf(0.01);

    @Override
    public void run() {
        try {
            Thread.sleep(30);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        synchronized (GrabRed2.class) {
            // 红包已经抢完
            if (count == 0) {
                System.out.println(Thread.currentThread().getName() + "没抢到");
            } else {
                BigDecimal prize;
                // 最后一个红包
                if (count == 1){
                    prize = money;
                } else {
                    double bounds = money.subtract(min.multiply(BigDecimal.valueOf(count - 1))).doubleValue();
                    // 随机出来红包小于最小值，取最小值
                    prize = BigDecimal.valueOf(Math.max(Math.random() * bounds, min.doubleValue()));
                }
                prize = prize.setScale(2, RoundingMode.HALF_UP);
                // 减去本次抽到的红包金额和个数
                money = money.subtract(prize);
                count--;
                System.out.println(Thread.currentThread().getName() + "抢到了" + prize + "元");
            }
        }
    }

}
