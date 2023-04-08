package com.sanfen.practice2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 9:26
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private Integer age;

    public void study(){
        System.out.println("学生在学习");
    }

}
