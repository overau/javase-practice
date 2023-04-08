package com.sanfen.practice.givegift;

/**
 * 送礼品
 * 有100分礼品，两人同时发送，当剩下的礼品小于10份的时候则不再送出
 * 利用多线程模拟该过程并将线程的名字和礼物的剩余数量打印出来
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 12:50
 */
public class GiveGiftTest {

    public static void main(String[] args) {
        GiveGift task = new GiveGift();
        Thread t1 = new Thread(task, "小明");
        Thread t2 = new Thread(task, "小红");
        t1.start();
        t2.start();
    }

}
