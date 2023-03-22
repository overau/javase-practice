package com.sanfen.object;

import com.google.gson.Gson;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/22 14:28
 */
public class ObjectClone {

    public static void main(String[] args) throws CloneNotSupportedException {
        int[] data = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 0};
        User u1 = new User(1, "张三", "123456", "girl11", data);
        // 克隆
        User u2 = u1.clone();
        // 修改u1
        int[] arr1 = u1.getData();
        arr1[0] = 100;

        System.out.println(u1);
        System.out.println(u2);

        // 第三方工具类gson进行对象深克隆
        Gson gson = new Gson();
        String json = gson.toJson(u1);
        System.out.println("json: " + json);
        User u3 = gson.fromJson(json, User.class);
        arr1[0] = 1000;
        System.out.println(u1);
        System.out.println(u3);
    }

}
