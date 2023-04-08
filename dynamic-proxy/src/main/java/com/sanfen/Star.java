package com.sanfen;

/**
 * 需要被代理的方法定义在接口当中
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 11:21
 */
public interface Star {

    /**
     * 唱
     * @param name 歌曲名字
     * @return String
     */
    String sing(String name);

    /**
     * 跳
     */
    void dance();

}