package com.sanfen.game;


import com.sanfen.domain.Poker;

import java.awt.*;
import java.util.List;

/**
 * 通用工具
 *
 * @author Administrator
 */
public class Common {

    /**
     * 移动牌（有移动的动画效果）
     *
     * @param poker 扑克牌实体
     * @param from  开始位置
     * @param to    结束位置
     */
    public static void move(Poker poker, Point from, Point to) {
        if (to.x != from.x) {
            double k = (1.0) * (to.y - from.y) / (to.x - from.x);
            double b = to.y - to.x * k;
            int flag;
            if (from.x < to.x) {
                flag = 20;
            } else {
                flag = -20;
            }
            for (int i = from.x; Math.abs(i - to.x) > 20; i += flag) {
                double y = k * i + b;

                poker.setLocation(i, (int) y);

                try {
                    Thread.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        poker.setLocation(to);

    }

    /**
     * 重新摆放牌
     *
     * @param container 游戏界面容器
     * @param list 要重新摆放顺序的集合
     * @param flag 标记: 0表示左边玩家 1表示中间自己  2表示右边玩家
     */
    public static void rePosition(Container container, List<Poker> list, int flag) {
        Point p = new Point();
        if (flag == 0) {
            p.x = 50;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        if (flag == 1) {
            p.x = (800 / 2) - (list.size() + 1) * 21 / 2;
            p.y = 450;
        }
        if (flag == 2) {
            p.x = 700;
            p.y = (450 / 2) - (list.size() + 1) * 15 / 2;
        }
        for (Poker poker : list) {
            move(poker, poker.getLocation(), p);
            container.setComponentZOrder(poker, 0);
            if (flag == 1) {
                p.x += 21;
            } else {
                p.y += 15;
            }
        }
    }
}
