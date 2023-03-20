package com.sanfen.ui;

import java.io.Serializable;

/**
 * 用户实体
 * @author HeJin
 * @version 1.0
 * @since 2023/03/19 14:37
 */
public class User implements Serializable {

    private static final long serialVersionUID = -2113511496284347451L;

    String username;

    String password;

    public User() {
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
