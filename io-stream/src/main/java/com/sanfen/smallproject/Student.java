package com.sanfen.smallproject;

import lombok.Data;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/03 14:09
 */
@Data
public class Student {

    private String name;

    private Integer gender;

    private Integer age;

    private Double weight;

    @Override
    public String toString() {
        return name + "-" + (gender.equals(0) ? "女" : "男") + "-" + age + "-" + weight;
    }
}
