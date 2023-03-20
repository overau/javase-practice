package com.sanfen.cmd2;

import java.util.*;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/20 20:48
 */
public class PokerGame {

    /**
     * 牌盒map: 牌跟序号产生对应关系
     */
    static Map<Integer, String> map = new HashMap<>();

    static List<Integer> list = new ArrayList<>();

    /*
    {
        1=♠3, 1=♣3, 2=♥3, 3=♦3, 4=♠4, 5=♣4, 6=♥4, 7=♦4, 8=♠5, 9=♣5, 10=♥5, 11=♦5, 12=♠6, 13=♣6, 14=♥6, 15=♦6,
        16=♠7, 17=♣7, 18=♥7, 19=♦7, 20=♠8, 21=♣8, 22=♥8, 23=♦8, 24=♠9, 25=♣9, 26=♥9, 27=♦9,
        28=♠10, 29=♣10, 30=♥10, 31=♦10, 32=♠J, 33=♣J, 34=♥J, 35=♦J, 36=♠Q, 37=♣Q, 38=♥Q, 39=♦Q,
        40=♠K, 41=♣K, 42=♥K, 43=♦K, 44=♠A, 45=♣A, 46=♥A, 47=♦A, 48=♠2, 49=♣2, 50=♥2, 51=♦2, 52=小王, 54=大王
    }
    */

    static {
        // 牌的花色
        String[] color = {"♠", "♣", "♥", "♦"};
        // 牌面数字
        String[] number = {"3", "4", "5", "6", "7", "8", "9", "10",
                "J", "Q", "K", "A", "2"};

        // 序号
        int serialNumber = 1;
        for (String n : number) {
            for (String c : color) {
                map.put(serialNumber, c + n);
                list.add(serialNumber);
                serialNumber++;
            }
        }
        map.put(serialNumber, "小王");
        list.add(serialNumber);
        serialNumber++;
        map.put(serialNumber, "大王");
        list.add(serialNumber);
    }

    public PokerGame(){
        // 洗牌
        Collections.shuffle(list);
        // 发牌: 使用TreeSet保存玩家的牌会自动排序
        Set<Integer> lord = new TreeSet<>();
        Set<Integer> play1 = new TreeSet<>();
        Set<Integer> play2 = new TreeSet<>();
        Set<Integer> play3 = new TreeSet<>();
        for (int i = 0; i < list.size(); i++) {
            // 牌的序号
            Integer serialNumber = list.get(i);
            if (i <= 2){
                lord.add(serialNumber);
                continue;
            }
            if (i % 3 == 0){
                play1.add(serialNumber);
            } else if (i % 3 == 1) {
                play2.add(serialNumber);
            } else {
                play3.add(serialNumber);
            }
        }
        // 看牌
        this.lookPoker("底牌", lord);
        this.lookPoker("钢脑壳", play1);
        this.lookPoker("大帅比", play2);
        this.lookPoker("蛋筒", play3);
    }

    /**
     * 看牌
     * @param name 玩家名字
     * @param set 牌的序号
     */
    private void lookPoker(String name, Set<Integer> set){
        StringJoiner joiner = new StringJoiner(", ");
        for (Integer serialNumber : set) {
            // 得到真正的牌
            String poker = map.get(serialNumber);
            joiner.add(poker);
        }
        System.out.println(name +": " + joiner);
    }

}
