package com.sanfen.reflect2;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 20:36
 */
@Data
@NoArgsConstructor
public class Student {

    private String name;

    private Integer age;

    private Student(String name) {
        this.name = name;
    }

    protected Student(Integer age) {
        this.age = age;
    }

    private Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
}
