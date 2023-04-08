package com.sanfen.practice;

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

    private String gender;

    private Double height;

    private String hobby;

}
