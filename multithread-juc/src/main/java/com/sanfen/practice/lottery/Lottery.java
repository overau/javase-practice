package com.sanfen.practice.lottery;

import cn.hutool.core.collection.CollUtil;

import java.util.Collections;
import java.util.List;

/**
 * 需求：有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为
 * {10,5,20,50,100,200,500,800,2,80,300,700};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
 * 随机从抽奖池中获取奖项元素并打印在控制台上,格式如下: 每次抽出一个奖项就打印一个(随机)
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 17:09
 */
public class Lottery implements Runnable {

    private final List<Integer> lotteryPool;

    public Lottery(List<Integer> lotteryPool) {
        this.lotteryPool = lotteryPool;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            synchronized (Lottery.class) {
                if (CollUtil.isEmpty(lotteryPool)) {
                    break;
                }
                Collections.shuffle(lotteryPool);
                System.out.println(Thread.currentThread().getName() + " 又产生了一个 " + lotteryPool.remove(0) + " 元大奖");
            }
        }
    }

}
