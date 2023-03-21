package com.sanfen.game;

import cn.hutool.core.util.RandomUtil;
import cn.hutool.core.util.StrUtil;
import com.sanfen.domain.User;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

/**
 * 登录界面
 * @author Administrator
 */
public class LoginJframe extends JFrame implements MouseListener {

    /**
     * 创建集合初始化一些用户信息
     */
    static List<User> userList = new ArrayList<>();

    static {
        userList.add(new User("admin", "123456"));
        userList.add(new User("test", "123456"));
    }

    JButton login = new JButton();
    JButton register = new JButton();
    JTextField username = new JTextField();
    JPasswordField password = new JPasswordField();
    JTextField code = new JTextField();

    /**
     * 正确的验证码
     */
    JLabel rightCode = new JLabel();
    String codeStr;


    public LoginJframe() {
        //初始化界面
        initJframe();
        //初始化组件，在这个界面中添加内容
        initView();
        //让当前界面显示出来
        this.setVisible(true);
    }

    public void initView() {
        //1. 添加用户名文字
        Font usernameFont = new Font(null, Font.BOLD,16);
        JLabel usernameText = new JLabel("用户名");
        usernameText.setForeground(Color.white);
        usernameText.setFont(usernameFont);
        usernameText.setBounds(140, 55, 55, 22);
        this.getContentPane().add(usernameText);

        //2.添加用户名输入框
        username.setBounds(223, 46, 200, 30);
        this.getContentPane().add(username);

        //3.添加密码文字
        JLabel passwordText = new JLabel("密码");
        Font passwordFont = new Font(null, Font.BOLD,16);
        passwordText.setForeground(Color.white);
        passwordText.setFont(passwordFont);
        passwordText.setBounds(197, 95, 40, 22);
        this.getContentPane().add(passwordText);

        //4.密码输入框
        password.setBounds(263, 87, 160, 30);
        this.getContentPane().add(password);

        //验证码提示
        JLabel codeText = new JLabel("验证码");
        Font codeFont = new Font(null, Font.BOLD,16);
        codeText.setForeground(Color.white);
        codeText.setFont(codeFont);
        codeText.setBounds(215, 142, 55, 22);
        this.getContentPane().add(codeText);

        //验证码的输入框
        code.setBounds(291, 133, 100, 30);
        this.getContentPane().add(code);

        //获取正确的验证码
        codeStr = RandomUtil.randomNumbers(6);
        Font rightCodeFont = new Font(null, Font.BOLD,15);
        //设置颜色
        rightCode.setForeground(Color.RED);
        //设置字体
        rightCode.setFont(rightCodeFont);
        //设置内容
        rightCode.setText(codeStr);
        //绑定鼠标事件
        rightCode.addMouseListener(this);
        //位置和宽高
        rightCode.setBounds(400, 133, 100, 30);
        //添加到界面
        this.getContentPane().add(rightCode);

        //5.添加登录按钮
        login.setBounds(123, 310, 128, 47);
        login.setIcon(new ImageIcon("farmerandlord\\image\\login\\登录按钮.png"));
        //去除按钮的边框
        login.setBorderPainted(false);
        //去除按钮的背景
        login.setContentAreaFilled(false);
        //给登录按钮绑定鼠标事件
        login.addMouseListener(this);
        this.getContentPane().add(login);

        //6.添加注册按钮
        register.setBounds(256, 310, 128, 47);
        register.setIcon(new ImageIcon("farmerandlord\\image\\login\\注册按钮.png"));
        //去除按钮的边框
        register.setBorderPainted(false);
        //去除按钮的背景
        register.setContentAreaFilled(false);
        //给注册按钮绑定鼠标事件
        register.addMouseListener(this);
        this.getContentPane().add(register);


        //7.添加背景图片
        JLabel background = new JLabel(new ImageIcon("farmerandlord\\image\\login\\background.png"));
        background.setBounds(0, 0, 633, 423);
        this.getContentPane().add(background);

    }

    public void initJframe() {
        //设置宽高
        this.setSize(633, 423);
        //设置标题
        this.setTitle("斗地主游戏 V1.0登录");
        //设置关闭模式
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //居中
        this.setLocationRelativeTo(null);
        //置顶
        this.setAlwaysOnTop(true);
        //取消内部默认布局
        this.setLayout(null);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object source = e.getSource();
        if (source == login){
            // 点击登录按钮
            // 获取用户输入的用户名、密码、验证码
            String usernameText = username.getText();
            String passwordText = new String(password.getPassword());
            String codeText = code.getText();
            // 用户名和密码不能为空
            if (StrUtil.isBlank(usernameText)){
                this.showJdialog("请输入用户名!");
                return;
            } else if (StrUtil.isBlank(passwordText)) {
                this.showJdialog("请输入密码!");
                return;
            }
            // 校验验证码
            if (!codeStr.equals(codeText)){
                this.showJdialog("验证码不正确!");
                return;
            }
            // 校验用户名和密码
            User user = new User(usernameText, passwordText);
            if (!userList.contains(user)){
                this.showJdialog("用户名或者密码错误!");
                return;
            }
            //登录成功, 进入游戏主界面
            System.out.println("登录成功");
            this.setVisible(false);
        } else if (source == register){
            // 点击注册按钮
            System.out.println("开始进行注册");
        } else if (source == rightCode){
            // 点击验证码: 生成新的验证码
            codeStr = RandomUtil.randomNumbers(6);
            rightCode.setText(codeStr);
        }
    }

    /**
     * //取消内部默认布局
     * @param content 消息内容
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
    public void mousePressed(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("farmerandlord\\image\\login\\登录按下.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("farmerandlord\\image\\login\\注册按下.png"));
        }
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (e.getSource() == login) {
            login.setIcon(new ImageIcon("farmerandlord\\image\\login\\登录按钮.png"));
        } else if (e.getSource() == register) {
            register.setIcon(new ImageIcon("farmerandlord\\image\\login\\注册按钮.png"));
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }


}