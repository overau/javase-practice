package com.sanfen.object;

import java.util.Arrays;

/**
 * 玩家
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 14:23
 */
public class User implements Cloneable{

    /**
     * 游戏角色
     */
    private int id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * 游戏图片
     */
    private String path;

    /**
     * 游戏进度
     */
    private int[] data;

    public User() {
    }

    public User(int id, String username, String password, String path, int[] data) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.path = path;
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public int[] getData() {
        return data;
    }

    public void setData(int[] data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", path='" + path + '\'' +
                ", data=" + Arrays.toString(data) +
                '}';
    }

    @Override
    protected User clone() throws CloneNotSupportedException {

        int[] data = this.data;
        int[] newData = new int[data.length];
        // 拷贝数据
        System.arraycopy(data, 0, newData, 0, data.length);
        // 调用父类(Object)的clone方法
        User u = (User) super.clone();
        // 因为Object中的克隆是浅克隆，替换克隆对象的数组变量地址值
        u.setData(newData);
        return u;
    }
}
