package com.sanfen.practice.lottery2;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringJoiner;

/**
 * 多线程统计并求最大值
 * 需求：有一个抽奖池,该抽奖池中存放了奖励的金额,该抽奖池中的奖项为
 * {10,5,20,50,100,200,500,800,2,80,300,700};
 * 创建两个抽奖箱(线程)设置线程名称分别为“抽奖箱1”，“抽奖箱2”
 * 每次抽的过程中，不打印，抽完时一次性打印(随机)
 * 在此次抽奖过程中，抽奖箱1总共产生了6个奖项。
 * 分别为：10,20,100,500,2,300最高奖项为300元，总计额为932元
 * 在此次抽奖过程中，抽奖箱2总共产生了6个奖项。
 * 分别为：5,50,200,800,80,700最高奖项为800元，总计额为1835元
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 17:09
 */
public class Lottery2 implements Runnable {

    private final List<Integer> lotteryPool;

    private final List<Integer> list1 = new ArrayList<>();

    private final List<Integer> list2 = new ArrayList<>();

    public Lottery2(List<Integer> lotteryPool) {
        this.lotteryPool = lotteryPool;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (Lottery2.class) {
                String name = Thread.currentThread().getName();
                if (CollUtil.isEmpty(lotteryPool)) {
                    List<Integer> list = "抽奖箱1".equals(name) ? list1 : list2;
                    System.out.println("在此次抽奖过程中，" + name + "总共产生了" + list.size() + "个奖项。");
                    StringJoiner joiner = new StringJoiner(", ");
                    list.forEach(n -> joiner.add(n.toString()));
                    Integer max = list.stream().reduce(Integer::max).orElse(0);
                    Integer sum = list.stream().reduce(0, Integer::sum);
                    System.out.println("分别为：" + joiner + " 最高奖项为" + max + "元，总计额为" + sum + "元");
                    break;
                }
                Collections.shuffle(lotteryPool);
                Integer prize = lotteryPool.remove(0);
                if ("抽奖箱1".equals(name)) {
                    list1.add(prize);
                } else {
                    list2.add(prize);
                }
            }
        }
    }

}
