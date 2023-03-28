package com.sanfen;

/**
 * 分块查找
 * @author HeJin
 * @version 1.0
 * @since 2023/03/28 18:41
 */
public class BlockSearch {

    public static void main(String[] args) {
        /*
            分块查找
            核心思想：
                块内无序，块间有序
            实现步骤：
                1.创建数组blockArr存放每一个块对象的信息
                2.先查找blockArr确定要查找的数据属于哪一块
                3.再单独遍历这一块数据即可
        */
        int[] arr = {
                16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};
        // 1.分块
        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);
        // 索引表
        Block[] blockArr = {b1, b2, b3};

        int number = 66;
        int index = getIndex(blockArr,arr, number);
        System.out.println(index);
    }

    /**
     * 利用分块查找的原理查找元素索引
     */
    private static int getIndex(Block[] blockArr, int[] arr, int number) {
        // 获取块的索引
        int indexBlock = findIndexBlock(blockArr, number);
        if (indexBlock == -1){
            return -1;
        }
        // 获取这一块的起始索引和结束索引
        int startIndex = blockArr[indexBlock].getStartIndex();
        int endIndex = blockArr[indexBlock].getEndIndex();
        // 遍历
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == number){
                return i;
            }
        }
        return -1;
    }

    /**
     * 确定number元素在哪一块中
     */
    public static int findIndexBlock(Block[] blockArr, int number){
        for (int i = 0; i < blockArr.length; i++) {
            if (number <= blockArr[i].getMax()){
                return i;
            }
        }
        return -1;
    }

}

class Block{
    /**
     * 最大值
     */
    private int max;

    /**
     * 起始索引
     */
    private int startIndex;

    /**
     * 结束索引
     */
    private int endIndex;

    public Block() {
    }

    public Block(int max, int startIndex, int endIndex) {
        this.max = max;
        this.startIndex = startIndex;
        this.endIndex = endIndex;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int max) {
        this.max = max;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }
}
