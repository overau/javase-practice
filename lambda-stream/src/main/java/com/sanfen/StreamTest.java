package com.sanfen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Stream流
 * @author HeJin
 * @version 1.0
 * @since 2023/03/24 13:20
 */
public class StreamTest {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5, 6);

        List<Integer> collect = list.stream()
                .filter(i -> i >= 3)
                .collect(Collectors.toList());
        System.out.println(collect);
    }

}
