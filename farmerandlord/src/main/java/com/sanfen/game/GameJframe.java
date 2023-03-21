package com.sanfen.game;

import com.sanfen.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/**
 * 游戏主界面
 * @author Administrator
 */
public class GameJframe extends JFrame implements ActionListener {

    /**
     * 玩家数量
     */
    private static final int PLAYER_COUNT = 3;
    /**
     * 界面中的隐藏容器
     */
    public static Container container = null;

    /**
     * 管理抢地主和不抢两个按钮
     */
    JButton[] landlord = new JButton[2];

    /**
     * 管理出牌和不要两个按钮
     */
    JButton[] publishCard = new JButton[2];

    /**
     * 游戏界面中地主的图标
     */
    JLabel diZhu;

    /**
     * 大集合中有3个小集合，小集合装着<span color='red'>玩家已经出的牌</span>
     * <p>0索引: 左边的电脑玩家</p>
     * <p>1索引: 中间的自己</p>
     * <p>2索引: 右边的电脑玩家</p>
     */
    ArrayList<ArrayList<Poker>> currentList = new ArrayList<>();

    /**
     * 大集合中有3个小集合，小集合装着<span color='red'>玩家手上的牌</span>
     * <p>0索引: 左边的电脑玩家</p>
     * <p>1索引: 中间的自己</p>
     * <p>2索引: 右边的电脑玩家</p>
     */
    ArrayList<ArrayList<Poker>> playerList = new ArrayList<>();

    /**
     * 底牌
     */
    ArrayList<Poker> lordList = new ArrayList<>();

    /**
     * 牌盒, 装所有的牌
     */
    ArrayList<Poker> pokerList = new ArrayList<>();

    /**
     * 3个玩家前方的文本提示
     * <p>0索引: 左边的电脑玩家</p>
     * <p>1索引: 中间的自己</p>
     * <p>2索引: 右边的电脑玩家</p>
     */
    JTextField[] time = new JTextField[3];

    public GameJframe() {
        //设置任务栏的图标
        this.setIconImage(Toolkit.getDefaultToolkit().getImage("farmerandlord\\image\\poker\\dizhu.png"));
        //设置界面
        this.initJframe();
        //添加组件
        this.initView();
        //界面显示出来
        //先展示界面再发牌，因为发牌里面有动画，界面不展示出来，动画无法展示
        this.setVisible(true);

        //初始化牌
        //准备牌，洗牌，发牌，排序
        this.initCard();
        //打牌之前的准备工作
        //展示抢地主和不抢地主两个按钮并且再创建三个集合用来装三个玩家准备要出的牌
        this.initGame();
    }

    /**
     * 初始化牌（准备牌，洗牌，发牌，排序）
     */
    public void initCard() {

    }

    /**
     * 排序
     * @param list 牌盒
     */
    public void order(ArrayList<Poker> list) {
        //自己练习
    }

    /**
     * 打牌之前的准备工作
     * @param poker 扑克牌
     * @return 牌的价值
     */
    public int getValue(Poker poker) {
       //自己练习
        return 0;
    }


    /**
     * 打牌之前的准备工作
     */
    private void initGame() {
        //创建三个集合用来装三个玩家准备要出的牌
        for (int i = 0; i < PLAYER_COUNT; i++) {
            ArrayList<Poker> list = new ArrayList<>();
            //添加到大集合中方便管理
            currentList.add(list);
        }

        //展示抢地主和不抢地主两个按钮
        landlord[0].setVisible(true);
        landlord[1].setVisible(true);

        //展示自己前面的倒计时文本
        for (JTextField field : time) {
            field.setText("倒计时30秒");
            field.setVisible(true);
        }

    }





    @Override
    public void actionPerformed(ActionEvent e) {
		
    }

    /**
     * 添加组件
     */
    public void initView() {
        //创建抢地主的按钮
        JButton robBut = new JButton("抢地主");
        //设置位置
        robBut.setBounds(320, 400, 75, 20);
        //添加点击事件
        robBut.addActionListener(this);
        //设置隐藏
        robBut.setVisible(false);
        //添加到数组中统一管理
        landlord[0] = robBut;
        //添加到界面中
        container.add(robBut);

        //创建不抢的按钮
        JButton noBut = new JButton("不     抢");
        //设置位置
        noBut.setBounds(420, 400, 75, 20);
        //添加点击事件
        noBut.addActionListener(this);
        //设置隐藏
        noBut.setVisible(false);
        //添加到数组中统一管理
        landlord[1] = noBut;
        //添加到界面中
        container.add(noBut);

        //创建出牌的按钮
        JButton outCardBut = new JButton("出牌");
        outCardBut.setBounds(320, 400, 60, 20);
        outCardBut.addActionListener(this);
        outCardBut.setVisible(false);
        publishCard[0] = outCardBut;
        container.add(outCardBut);

        //创建不要的按钮
        JButton noCardBut = new JButton("不要");
        noCardBut.setBounds(420, 400, 60, 20);
        noCardBut.addActionListener(this);
        noCardBut.setVisible(false);
        publishCard[1] = noCardBut;
        container.add(noCardBut);


        //创建三个玩家前方的提示文字：倒计时
        //每个玩家一个
        //左边的电脑玩家是0
        //中间的自己是1
        //右边的电脑玩家是2
        for (int i = 0; i < PLAYER_COUNT; i++) {
            time[i] = new JTextField("倒计时:");
            time[i].setEditable(false);
            time[i].setVisible(false);
            container.add(time[i]);
        }
        time[0].setBounds(140, 230, 80, 20);
        time[1].setBounds(374, 360, 80, 20);
        time[2].setBounds(620, 230, 80, 20);


        //创建地主图标
        diZhu = new JLabel(new ImageIcon("images/dizhu.png"));
        diZhu.setVisible(false);
        diZhu.setSize(40, 40);
        container.add(diZhu);
    }

    public void initJframe() {
        //设置标题
        this.setTitle("斗地主");
        //设置大小
        this.setSize(830, 620);
        //设置关闭模式
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //设置窗口无法进行调节
        this.setResizable(false);
        //界面居中
        this.setLocationRelativeTo(null);
        //获取界面中的隐藏容器，以后直接用无需再次调用方法获取了
        container = this.getContentPane();
        //取消内部默认的居中放置
        container.setLayout(null);
        //设置背景颜色
        container.setBackground(Color.LIGHT_GRAY);
    }

}