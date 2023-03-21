package com.sanfen.cmd3;

import java.util.*;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/20 20:48
 */
public class PokerGame {

    /**
     * 牌盒
     */
    static List<String> list = new ArrayList<>();

    /**
     * map集合，用了添加牌的价值
     */
    static Map<String, Integer> map = new HashMap<>(7);

    static {
        // 牌的花色
        String[] color = {"♠", "♣", "♥", "♦"};
        // 牌面数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A", "2"};

        for (String c : color) {
            for (String n : number) {
                list.add(c + n);
            }
        }
        // 牌的格式: ♠3
        // 为了后面统一进行截取 poker.substring(1)，在大王和小王牌之前添加空格
        list.add(" 小王");
        list.add(" 大王");

        // 添加牌的价值
        map.put("J", 11);
        map.put("Q", 12);
        map.put("K", 13);
        map.put("A", 14);
        map.put("2", 15);
        map.put("小王", 50);
        map.put("大王", 100);
    }

    public PokerGame() {
        // 洗牌
        Collections.shuffle(list);
        // 发牌
        List<String> lord = new ArrayList<>();
        List<String> play1 = new ArrayList<>();
        List<String> play2 = new ArrayList<>();
        List<String> play3 = new ArrayList<>();
        for (int i = 0; i < list.size(); i++) {
            // 获取到牌
            String poker = list.get(i);
            // 地主牌
            if (i <= 2) {
                lord.add(poker);
                continue;
            }
            // 给三个玩家轮流发牌
            if (i % 3 == 0) {
                play1.add(poker);
            } else if (i % 3 == 1) {
                play2.add(poker);
            } else {
                play3.add(poker);
            }
        }

        // 排序
        this.order(lord);
        this.order(play1);
        this.order(play2);
        this.order(play3);

        // 看牌
        this.lookPoker("底牌", lord);
        this.lookPoker("钢脑壳", play1);
        this.lookPoker("大帅比", play2);
        this.lookPoker("蛋筒", play3);
    }

    /**
     * 利用牌的价值进行排序
     * @param list 牌的集合
     */
    private void order(List<String> list){
        list.sort((o1, o2) -> {
            // 计算o1的花色和价值
            String color1 = o1.substring(0, 1);
            int value1 = this.getValue(o1);
            // 计算o2的花色和价值
            String color2 = o2.substring(0, 1);
            int value2 = this.getValue(o2);
            // 比较o1和o2的价值: 价值一样, 比较牌的花色
            int i = value1 - value2;
            return i == 0 ? color1.compareTo(color2) : i;
        });
    }

    /**
     * 计算牌的价值
     * @param poker 牌
     * @return 牌的价值
     */
    private int getValue(String poker){
        String number = poker.substring(1);
        if (map.containsKey(number)){
            return map.get(number);
        } else {
            return Integer.parseInt(number);
        }
    }

    /**
     * 看牌
     *
     * @param name 玩家名字
     * @param set  牌的序号
     */
    private void lookPoker(String name, List<String> set) {
        StringJoiner joiner = new StringJoiner(", ");
        for (String poker : set) {
            joiner.add(poker);
        }
        System.out.println(name + ": " + joiner);
    }

}
