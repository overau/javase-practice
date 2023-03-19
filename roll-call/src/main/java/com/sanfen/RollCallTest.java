package com.sanfen;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.util.*;
import java.util.stream.Collectors;

/**
 * 随机点名器 班里有n个学生，学生属性: 姓名、年龄、性别，实现随机点名
 *
 * @author HeJin
 * @version 1.0
 * @since 2023/03/18 9:50
 */
@Slf4j
public class RollCallTest {

    private static final List<Student> STUDENT_LIST = new ArrayList<>(
            Arrays.asList(
                    new Student("张三", 20, "女"),
                    new Student("李四", 28, "男"),
                    new Student("王五", 27, "男"),
                    new Student("小六", 29, "女"),
                    new Student("杨羊", 15, "男"),
                    new Student("小德子", 35, "男"),
                    new Student("22娘", 16, "女"),
                    new Student("33娘", 15, "女"),
                    new Student("44叔", 30, "男"),
                    new Student("张珊珊", 22, "女")));

    /**
     * 随机点名
     */
    @Test
    public void test01() {
        Collections.shuffle(STUDENT_LIST);
        Student student = STUDENT_LIST.get(0);
        log.info("被点到的人是: {}, 年龄: {}, 性别: {}", student.getName(),
                student.getAge(), student.getGender());
    }

    /**
     * 随机点名: 70%随机到男生, 30%随机到女生
     */
    @Test
    public void test02() {
        List<Student> maleList = STUDENT_LIST.stream()
                .filter(student -> "男".equals(student.getGender()))
                .collect(Collectors.toList());
        List<Student> femalList = STUDENT_LIST.stream()
                .filter(student -> "女".equals(student.getGender()))
                .collect(Collectors.toList());
        Collections.shuffle(femalList);
        Random random = new Random();
        int i = random.nextInt(STUDENT_LIST.size());
        if (i <= STUDENT_LIST.size() * 0.7) {
            // 男生随机点名
            Collections.shuffle(maleList);
            Student student = maleList.get(0);
            log.info("被点到的人是: {}, 年龄: {}, 性别: {}", student.getName(),
                    student.getAge(), student.getGender());
        } else {
            // 女生随机点名
            Collections.shuffle(femalList);
            Student student = femalList.get(0);
            log.info("被点到的人是: {}, 年龄: {}, 性别: {}", student.getName(),
                    student.getAge(), student.getGender());
        }
    }

    /**
     * 随机点名:
     * (1)被点到的学生不会再被点到
     * (2)如果班级中所有的学生都点完了，需要重新开启第二轮点名
     */
    @Test
    public void test03() {
        List<Student> calledStu = new ArrayList<>(STUDENT_LIST.size());
        for (int i = 1; i <= 10; i++) {
            log.info("===================第 {} 轮点名开始了=====================", i);
            int size = STUDENT_LIST.size();
            // 随机点名
            for (int j = 0; j < size; j++) {
                Collections.shuffle(STUDENT_LIST);
                Student student = STUDENT_LIST.get(0);
                log.info("被点到的人是: {}", student);
                // 从STUDENT_LIST移除,加入已经点过名的集合
                Student remove = STUDENT_LIST.remove(0);
                calledStu.add(remove);
            }
            STUDENT_LIST.addAll(calledStu);
            calledStu.clear();
        }
    }

}
