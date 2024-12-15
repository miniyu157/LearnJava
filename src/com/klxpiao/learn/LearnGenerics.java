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

class Pair<T> {
    private T first;
    private T last;

    public Pair(T first, T last) {
        this.first = first;
        this.last = last;
    }

    public T getFirst() {
        return null;
    }

    public T getLast() {
        return null;
    }

    // 静态泛型方法应该使用其他类型区分:
    public static <K> Pair<K> create(K first, K last) {
        return new Pair<K>(first, last);
    }
}
