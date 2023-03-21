package com.sanfen.domain;


import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

/**
 * 扑克牌实体
 * @author Administrator
 */
public class Poker extends JLabel implements MouseListener {

    /**
     * 牌的名字: 数字-数字(花色-牌面值)
     */
    private String name;

    /**
     * 牌显示正面还是反面
     */
    private boolean up;

    /**
     * 牌能否被点击
     */
    private boolean canClick = false;

    /**
     * 当前的状态，表示当前的牌是否已经被点击
     * <p>如果没有被点击，此时点击之后，牌就会弹起的操作</p>
     * <p>如果被点击了，再次点击之后，牌就会降落的操作</p>
     */
    private boolean clicked = false;

    public Poker(String name, boolean up){
        this.name = name;
        this.up = up;

        if (this.up){
            // 牌显示正面
            this.turnFront();
        } else {
            // 牌显示反面
            this.turnRear();
        }

        // 设置牌的宽高
        this.setSize(71, 96);
        // 显示牌
        this.setVisible(true);
        // 给每一张牌添加监听
        this.addMouseListener(this);
    }

    /**
     * 牌显示正面
     */
    public void turnFront(){
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\"+ this.name +".png"));
        this.up = true;
    }

    /**
     * 牌显示反面
     */
    public void turnRear(){
        this.setIcon(new ImageIcon("farmerandlord\\image\\poker\\rear.png"));
        this.up = false;
    }

    /**
     * 点击牌
     */
    @Override
    public void mouseClicked(MouseEvent e) {

        if (this.canClick){
            // 牌能够被点击，要么升起，要么降落
            // 牌的位移像素
            int step;
            if (this.clicked){
                // 牌已经被点击，降落
                step = 20;
            } else {
                // 牌还没有被点击，升起
                step = -20;
            }
            // 修改clicked记录的值
            clicked = !clicked;
            // 修改牌的位置
            Point from = this.getLocation();
            Point to = new Point(from.x, from.y + step);
            this.setLocation(to);
        }
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public boolean isUp() {
        return up;
    }

    public void setUp(boolean up) {
        this.up = up;
    }

    public boolean isCanClick() {
        return canClick;
    }

    public void setCanClick(boolean canClick) {
        this.canClick = canClick;
    }

    public boolean isClicked() {
        return clicked;
    }

    public void setClicked(boolean clicked) {
        this.clicked = clicked;
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
