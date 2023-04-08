package com.sanfen.practice2;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author HeJin
 * @version 1.0
 * @since 2023/04/08 9:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Teacher {

    private String name;

    private Integer salary;

    public void teach(){
        System.out.println("老师在教书");
    }

}
