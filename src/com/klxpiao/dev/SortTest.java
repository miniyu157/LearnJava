package com.klxpiao.dev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SortTest {
    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        List<Integer> list = new ArrayList<>();
        Arrays.stream(array).forEach(list::add); //n -> list.add(n)

        list.add(1, 99);

        System.out.println(list);
    }
}
