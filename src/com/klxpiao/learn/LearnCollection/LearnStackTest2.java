package com.klxpiao.learn.LearnCollection;

import java.util.Map;

public class LearnStackTest2 {
    //请把带变量的中缀表达式编译为后缀表达式，执行后缀表达式时，传入变量的值并获得计算结果：
    public static void main(String[] args) {
        String exp = "x + 2 * (y - 5)";
        SuffixExpression2 se = compile(exp);
        Map<String, Integer> env = Map.of("x", 1, "y", 9);
        int result = se.execute(env);
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression2 compile(String exp) {
        // TODO:
        return new SuffixExpression2();
    }
}

class SuffixExpression2 {
    int execute(Map<String, Integer> env) {
        // TODO:
        return 0;
    }
}