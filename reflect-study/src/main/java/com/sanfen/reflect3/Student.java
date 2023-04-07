package com.sanfen.reflect3;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/07 21:28
 */
@Data
@AllArgsConstructor
public class Student {

    private String name;

    private Integer age;

    public String gender;

}
