package com.sanfen;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 学生
 * @author HeJin
 * @version 1.0
 * @since 2023/03/17 21:50
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Student {

    private String name;

    private Integer age;

    private String gender;

}
