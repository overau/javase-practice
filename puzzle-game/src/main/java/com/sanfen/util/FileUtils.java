package com.sanfen.util;

import com.sanfen.domain.User;

import java.io.File;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/03/19 18:25
 */
public class FileUtils {

    /**
     * 用户实体对象序列化到本地文件
     * @param file 本地序列化文件
     * @param user 用户实体对象
     */
    public static void writeUserToFile(File file, User user){
        try {
            ObjectOutputStream outputStream = new ObjectOutputStream(Files.newOutputStream(file.toPath()));
            outputStream.writeObject(user);
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }
    }

    /**
     * 从文件夹加载用户实体数据
     * @param file 文件夹
     * @return 用户实体集合
     */
    public static List<User> loadUsersFromDir(File file){
        List<User> userList = new ArrayList<>();
        File[] files = file.listFiles();
        if (files != null){
            for (File userFile : files) {
                try {
                    ObjectInputStream inputStream = new ObjectInputStream(Files.newInputStream(userFile.toPath()));
                    User user = (User) inputStream.readObject();
                    userList.add(user);
                } catch (IOException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        }
        return userList;
    }

    /**
     * 创建新文件
     * @param file 文件
     */
    public static void createNewFile(File file) {
        try {
            boolean newFile = file.createNewFile();
            if (!newFile){
                throw new RuntimeException("创建新文件失败!");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void mkDirs(File file){
        boolean newFile = file.mkdirs();
        if (!newFile){
            throw new RuntimeException("创建新文件失败!");
        }
    }

}
