package com.sanfen.reflect4;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 21:45
 */
public class Student {

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

    public void sleep() {
        System.out.println("睡觉");
    }

    private void eat(String something) {
        System.out.println(this.name + "在吃" + something);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
