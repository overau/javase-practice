package com.sanfen.game;

import com.sanfen.domain.Poker;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.*;

/**
 * 游戏主界面
 *
 * @author Administrator
 */
public class GameJframe extends JFrame implements ActionListener {

    /**
     * 玩家数量
     */
    public static final int PLAYER_COUNT = 3;

    /**
     * 扑克牌花色: 1(黑桃) 2(红桃) 3(梅花) 4(方块) 5(大王小王)
     */
    public static final int POKER_COLOR_COUNT = 5;

    /**
     * 大王和小王的花色
     */
    public static final String POKER_COLOR_JOKER = "5";

    /**
     * 扑克牌数字: 2 3 4 5 6 7 8 9 10 11(J) 12(Q) 13(K) 1(A)
     */
    public static final int POKER_NUMBER_COUNT = 13;

    /**
     * 存储牌的价值
     */
    static Map<String, Integer> map = new HashMap<>();

    static {
        map.put("11", 11);
        map.put("12", 12);
        map.put("13", 13);
        map.put("1", 14);
        map.put("2", 15);
        map.put("5-1", 50);
        map.put("5-2", 100);
    }

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
     * 3个玩家前方的文本提示
     * <p>0索引: 左边的电脑玩家</p>
     * <p>1索引: 中间的自己</p>
     * <p>2索引: 右边的电脑玩家</p>
     */
    JTextField[] time = new JTextField[3];

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
    List<List<Poker>> currentList = new ArrayList<>();

    /**
     * 大集合中有3个小集合，小集合装着<span color='red'>玩家手上的牌</span>
     * <p>0索引: 左边的电脑玩家</p>
     * <p>1索引: 中间的自己</p>
     * <p>2索引: 右边的电脑玩家</p>
     */
    List<List<Poker>> playerList = new ArrayList<>();

    /**
     * 底牌
     */
    List<Poker> lordList = new ArrayList<>();

    /**
     * 牌盒, 装所有的牌
     */
    List<Poker> pokerList = new ArrayList<>();

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
        // 准备牌
        for (int i = 1; i <= POKER_COLOR_COUNT; i++) {
            for (int j = 1; j <= POKER_NUMBER_COUNT; j++) {
                // 小王(5-1) 大王(5-2)
                if (i == 5 && j > 2) {
                    break;
                }
                Poker poker = new Poker(i + "-" + j, false);
                poker.setLocation(350, 150);
                pokerList.add(poker);
                // 把扑克牌添加到界面容器中
                container.add(poker);
            }
        }
        // 洗牌
        Collections.shuffle(pokerList);
        // 发牌
        List<Poker> player1 = new ArrayList<>();
        List<Poker> player2 = new ArrayList<>();
        List<Poker> player3 = new ArrayList<>();
        for (int i = 0; i < pokerList.size(); i++) {
            Poker poker = pokerList.get(i);
            // 底牌
            if (i <= 2) {
                lordList.add(poker);
                // 添加底牌界面动画
                Common.move(poker, poker.getLocation(), new Point(270 + (75 * i), 10));
                continue;
            }
            // 轮流发牌
            if (i % PLAYER_COUNT == 0) {
                player1.add(poker);
                // 给左边的电脑发牌
                Common.move(poker, poker.getLocation(), new Point(50, 60 + i * 5));
            } else if (i % PLAYER_COUNT == 1) {
                player2.add(poker);
                // 给中间的自己发牌
                Common.move(poker, poker.getLocation(), new Point(180 + i * 7, 450));
                //把自己的牌展示正面
                poker.turnFront();
            } else {
                player3.add(poker);
                // 给右边的电脑发牌
                Common.move(poker, poker.getLocation(), new Point(700, 60 + i * 5));
            }
            // 当前的牌置于最顶端，这样会有牌依次错开叠起来的效果
            container.setComponentZOrder(poker, 0);
        }
        playerList.add(player1);
        playerList.add(player2);
        playerList.add(player3);
        // 对3个玩家手上的牌进行排序
        for (int i = 0; i < PLAYER_COUNT; i++) {
            this.order(playerList.get(i));
            Common.rePosition(container, playerList.get(i), i);
        }
    }

    /**
     * 对牌集合进行排序
     *
     * @param list 牌盒
     */
    public void order(List<Poker> list) {
        list.sort((o1, o2) -> {
            String color1 = o1.getName().split("-")[0];
            int value1 = this.getValue(o1);
            String color2 = o2.getName().split("-")[0];
            int value2 = this.getValue(o2);
            // 比较: 优先比较价值，价值相同，比较花色
            int i = value1 - value2;
            return i == 0 ? color1.compareTo(color2) : i;
        });
    }

    /**
     * 获取牌的价值
     *
     * @param poker 扑克牌
     * @return 牌的价值
     */
    public int getValue(Poker poker) {
        String color = poker.getName().split("-")[0];
        String number = poker.getName().split("-")[1];
        int value;
        // 花色"5"表示大王或者小王
        if (POKER_COLOR_JOKER.equals(color)) {
            return map.get(poker.getName());
        }
        if (map.containsKey(number)) {
            value = map.get(number);
        } else {
            value = Integer.parseInt(number);
        }
        return value;
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
        if (e.getSource() == landlord[0]) {
            //点击抢地主
            time[1].setText("抢地主");
            List<Poker> player1 = playerList.get(1);
            player1.addAll(lordList);
            lordList.clear();
            this.order(playerList.get(1));
            for (Poker poker : player1) {
                poker.turnFront();
            }
            landlord[0].setVisible(false);
            landlord[1].setVisible(false);
            diZhu.setVisible(true);
            diZhu.setLocation(this.getWidth() - 118, this.getHeight() - 140);
            Common.rePosition(container, playerList.get(1),1);
        } else if (e.getSource() == landlord[1]) {
            //点击不抢
            time[1].setText("不抢");
        } else if (e.getSource() == publishCard[1]) {
            //点击不要
            time[1].setText("不要");
        } else if (e.getSource() == publishCard[0]) {
            time[1].setText("出牌");
        }
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
        diZhu = new JLabel(new ImageIcon("farmerandlord\\image\\poker\\dizhu.png"));
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