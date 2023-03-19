package com.sanfen.ui;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import cn.hutool.crypto.SecureUtil;
import com.sanfen.util.FileUtils;

import javax.swing.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

/**
 * 注册界面
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 13:46
 */
public class RegisterJframe extends JFrame implements MouseListener {

    /**
     * 注册按钮
     */
    JButton register = new JButton();

    /**
     * 重置按钮
     */
    JButton reset = new JButton();

    /**
     * 注册用户名输入框
     */
    JTextField username = new JTextField();

    /**
     * 注册密码输入框
     */
    JTextField password = new JPasswordField();

    /**
     * 注册密码确认框
     */
    JTextField rePassword = new JPasswordField();

    public RegisterJframe(){
        //初始化界面
        initJframe();

        //在这个界面中添加内容
        initView();

        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        // 1.注册用户名
        JLabel usernameText = new JLabel(new ImageIcon(RegisterConstants.REGISTER_USERNAME_IMAGE));
        usernameText.setBounds(100, 135, 79, 17);
        this.getContentPane().add(usernameText);

        username.setBounds(195, 130, 200, 30);
        this.getContentPane().add(username);

        // 2.注册密码
        JLabel passwordText = new JLabel(new ImageIcon(RegisterConstants.REGISTER_PASSWORD_IMAGE));
        passwordText.setBounds(115, 195, 64, 16);
        this.getContentPane().add(passwordText);

        password.setBounds(195, 190, 200, 30);
        this.getContentPane().add(password);

        // 3.确认密码
        JLabel rePasswordText = new JLabel(new ImageIcon(RegisterConstants.REGISTER_RE_PASSWORD_IMAGE));
        rePasswordText.setBounds(82, 260, 100, 16);
        this.getContentPane().add(rePasswordText);

        rePassword.setBounds(195, 255, 200, 30);
        this.getContentPane().add(rePassword);

        //4.添加注册按钮
        register.setBounds(123, 310, 128, 47);
        register.setIcon(new ImageIcon(RegisterConstants.REGISTER_BUTTON_IMAGE));
        //去除按钮的默认边框
        register.setBorderPainted(false);
        //去除按钮的默认背景
        register.setContentAreaFilled(false);
        this.getContentPane().add(register);

        //6.添加注册按钮
        reset.setBounds(256, 310, 128, 47);
        reset.setIcon(new ImageIcon(RegisterConstants.RESET_BUTTON_IMAGE));
        //去除按钮的默认边框
        reset.setBorderPainted(false);
        //去除按钮的默认背景
        reset.setContentAreaFilled(false);
        this.getContentPane().add(reset);

        // 添加事件
        register.addMouseListener(this);
        reset.addMouseListener(this);

        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon(RegisterConstants.BACKGROUND_IMAGE));
        background.setBounds(0, 0, 470, 390);
        this.getContentPane().add(background);
    }


    public void initJframe() {
        //设置宽高
        this.setSize(488, 430);
        //设置标题
        this.setTitle("拼图游戏 V1.0注册");
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //居中
        this.setLocationRelativeTo(null);
        //置顶
        this.setAlwaysOnTop(true);
        //取消内部默认布局
        this.setLayout(null);
    }


    /**
     * 要展示用户名或密码错误
     * @param content 内容
     */
    public void showJdialog(String content) {
        //创建一个弹框对象
        JDialog jDialog = new JDialog();
        //给弹框设置大小
        jDialog.setSize(200, 150);
        //让弹框置顶
        jDialog.setAlwaysOnTop(true);
        //让弹框居中
        jDialog.setLocationRelativeTo(null);
        //弹框不关闭永远无法操作下面的界面
        jDialog.setModal(true);

        //创建Jlabel对象管理文字并添加到弹框当中
        JLabel warning = new JLabel(content);
        warning.setBounds(0, 0, 200, 150);
        jDialog.getContentPane().add(warning);

        //让弹框展示出来
        jDialog.setVisible(true);
    }

    @Override
    public void mouseClicked(MouseEvent e) {

    }

    @Override
    public void mousePressed(MouseEvent e) {
        Object source = e.getSource();
        if (source == register){
            // 鼠标按下改变注册按钮图标
            register.setIcon(new ImageIcon(RegisterConstants.REGISTER_PRESS_BUTTON_IMAGE));
        } else if (source == reset) {
            // 鼠标按下改变重置按钮图标
            reset.setIcon(new ImageIcon(RegisterConstants.RESET_PRESS_BUTTON_IMAGE));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        Object source = e.getSource();
        if (source == register){
            // 注册逻辑
            register.setIcon(new ImageIcon(RegisterConstants.REGISTER_BUTTON_IMAGE));
            String usernameText = username.getText();
            String passwordText = password.getText();
            String rePasswordText = rePassword.getText();
            if (StrUtil.isBlank(usernameText)){
                this.showJdialog("请输入用户名!");
                return;
            } else if (StrUtil.isBlank(passwordText)){
                this.showJdialog("请输入密码!");
                return;
            } else if (StrUtil.isBlank(rePasswordText)){
                this.showJdialog("请确认密码!");
                return;
            }
            // 判断两次输入的密码是否一致
            if (!passwordText.equals(rePasswordText)){
                this.showJdialog("请确保两次输入的密码一致!");
                return;
            }
            // 保存用户信息
            User user = new User();
            user.setUsername(usernameText);
            user.setPassword(SecureUtil.sha1(passwordText));
            File saveDir = new File(RegisterConstants.USER_REGISTER_DATA);
            if (!saveDir.exists()){
                FileUtils.mkDirs(saveDir);
            }
            File file = new File(saveDir, RandomUtil.randomString(32));
            if (file.exists()){
                this.showJdialog("用户名已存在，请更换注册名称!");
                return;
            } else {
                FileUtils.createNewFile(file);
            }
            FileUtils.writeUserToFile(file, user);
            this.showJdialog("注册成功~~");
            this.dispose();
            // 进入登录界面
            new LoginJframe();
        } else if (source == reset) {
            // 重置逻辑
            reset.setIcon(new ImageIcon(RegisterConstants.RESET_BUTTON_IMAGE));
            username.setText("");
            password.setText("");
            rePassword.setText("");
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
