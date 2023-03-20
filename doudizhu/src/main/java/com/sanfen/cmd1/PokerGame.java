package com.sanfen.cmd1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 控制台版斗地主
 * @author HeJin
 * @version 1.0
 * @since 2023/03/20 20:14
 */
public class PokerGame {

    /**
     * 装牌的牌盒
     */
    static List<String> list;

    // 准备牌
    static {
        // 牌的花色
        String[] color = {"♠", "♣", "♥", "♦"};
        // 牌面数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A", "2"};
        // 牌盒
        list = new ArrayList<>();
        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        list.add("小王");
        list.add("大王");
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        System.out.println(list);
        // 发牌
        List<String> lord = new ArrayList<>();
        List<String> player1 = new ArrayList<>();
        List<String> player2 = new ArrayList<>();
        List<String> player3 = new ArrayList<>();
        // 遍历牌盒得到每一张牌
        for (int i = 0; i < list.size(); i++) {
            String poker = list.get(i);
            // 前三张牌作为地主牌
            if (i <= 2) {
                lord.add(poker);
                continue;
            }
            // 给三个玩家轮流发牌
            if (i % 3 == 0){
                // 发给第1个玩家
                player1.add(poker);
            } else  if (i % 3 == 1){
                // 发给第2个玩家
                player2.add(poker);
            } else {
                // 发给第3个玩家
                player3.add(poker);
            }
        }
        // 看牌
        this.lookPoker("底牌", lord);
        this.lookPoker("钢脑壳", player1);
        this.lookPoker("大帅比", player2);
        this.lookPoker("蛋筒", player3);
    }

    private void lookPoker(String name, List<String> list){
        System.out.println(name + ": " + list);
    }

}
