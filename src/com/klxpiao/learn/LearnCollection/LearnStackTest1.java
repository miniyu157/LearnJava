package com.klxpiao.learn.LearnCollection;

public class LearnStackTest1 {
    //进阶练习：
    //请利用Stack把字符串中缀表达式编译为后缀表达式，然后再利用栈执行后缀表达式获得计算结果：
    public static void main(String[] args) {
        String exp = "1 + 2 * (9 - 5)";
        SuffixExpression2 se = compile(exp);
        int result = se.execute();
        System.out.println(exp + " = " + result + " " + (result == 1 + 2 * (9 - 5) ? "✓" : "✗"));
    }

    static SuffixExpression2 compile(String exp) {
        // TODO:
        return new SuffixExpression2();
    }
}

class SuffixExpression {
    int execute() {
        // TODO:
        return 0;
    }
}
