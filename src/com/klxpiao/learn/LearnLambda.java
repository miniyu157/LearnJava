package com.klxpiao.learn;

import java.util.Arrays;
import java.util.List;

public class LearnLambda {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        //Where
        List<Integer> evens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .toList();

        //Select
        List<Integer> squares = numbers.stream()
                .map(n -> n * n)
                .toList();

        List<Integer> evenSquares = numbers.stream()
                .filter(n -> n % 2 == 0)
                .map(n -> n * n)
                .toList();

        System.out.println("Evens: " + evens);
        System.out.println("Squares: " + squares);
        System.out.println("Even Squares: " + evenSquares);

        numbers.forEach(System.out::println); //不用显式调用lambda表达式，直接调用方法引用
        numbers.forEach(num -> System.out.println(num));
    }
}
