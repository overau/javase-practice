package com.sanfen.ui;

/**
 * 用户实体
 * @author HeJin
 * @version 1.0
 * @since 2023/03/19 14:37
 */
public class User {

    String username;

    String password;

    public User() {
    }

    public User(String username, String password) {
        this.username = username;
        this.password = password;
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
}
