package com.klxpiao.learn;

import java.util.*;
import java.math.*;

import static java.lang.System.out;

public class LearnGenerics {
    public static void main(String[] args) {
        Integer[] arr = {45, 25, 69, 85, 47};
        out.println(max(arr));
    }

    static <T extends Number> T max(T[] arr) {
        T max = arr[0];
        for (T e : arr)
            max = max(e, max);
        return max;
    }

    static <T extends Number> T max(T a, T b) {
        return a.doubleValue() > b.doubleValue() ? a : b;
    }
}
