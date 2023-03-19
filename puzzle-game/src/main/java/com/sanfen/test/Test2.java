package com.sanfen.test;

import com.sanfen.ui.GameConstants;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 17:13
 */
public class Test2{

    public static void main(String[] args) {
        JFrame jFrame = new JFrame();
        jFrame.setSize(GameConstants.GAME_WIDTH, GameConstants.GAME_HEIGHT);
        jFrame.setTitle("事件演示");
        jFrame.setAlwaysOnTop(true);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        jFrame.setLayout(null);

        JButton jButton = new JButton("点我呀");
        jButton.setBounds(0, 0, 100, 50);
        // 监听鼠标左键或者空格
        jButton.addActionListener(e -> {
            System.out.println("按钮被点击了");
            jButton.setSize(200, 200);
            Random random = new Random();
            jButton.setLocation(random.nextInt(300), random.nextInt(500));
        });

        jFrame.getContentPane().add(jButton);

        jFrame.setVisible(true);
    }

}
