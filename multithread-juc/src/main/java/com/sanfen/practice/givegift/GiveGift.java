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
public class GiveGift implements Runnable{

    /**
     * 礼品的数量
     */
    private int gift = 100;

    @Override
    public void run() {
        while (true) {
            synchronized (GiveGift.class){
                System.out.println("(" + Thread.currentThread().getName() + ")礼物剩余数量: " + gift);
                if (gift < 10){
                    System.out.println("礼物还剩下" + gift + "不再赠送");
                    break;
                }
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                gift--;
            }
        }
    }
}
