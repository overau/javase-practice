package com.sanfen.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 游戏存档信息
 * @author HeJin
 * @version 1.0
 * @since 2023/04/06 14:57
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class GameInfo implements Serializable {

    private static final long serialVersionUID = -250151387173545632L;

    /**
     * 空白方块在二维数组中的位置: x
     */
    int zeroX = 0;

    /**
     * 空白方块在二维数组中的位置: y
     */
    int zeroY = 0;

    /**
     * 图片路径
     */
    private String path;

    /**
     * 步数统计
     */
    int step = 0;

    /**
     * 二维数组，用来管理数据 加载图片的时候，会根据二维数组中的数据进行加载
     */
    private int[][] data;

}
