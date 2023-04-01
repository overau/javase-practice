package com.sanfen.io.objectstream;

import java.io.Serializable;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/01 17:33
 */
public class Student implements Serializable {

    private static final long serialVersionUID = 481158486186850516L;

    private String name;

    private Integer age;

    public Student() {
    }

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
