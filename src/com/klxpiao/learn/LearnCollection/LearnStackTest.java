package com.klxpiao.learn.LearnCollection;

import java.util.Stack;

import static java.lang.System.out;

public class LearnStackTest {
    //请利用Stack把一个给定的整数转换为十六进制：

    public static void main(String[] args) {
        String hex = toHex(12500);
        out.println(hex);
        if (hex.equalsIgnoreCase("30D4")) {
            out.println("测试通过");
        } else {
            out.println("测试失败");
        }
    }

    static String toHex(int n) {
        Stack<Character> stack = new Stack<>();
        char[] chars = "0123456789ABCDEF".toCharArray();
        while (n > 0) {
            stack.push(chars[n % 16]);
            n /= 16;
        }
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }
        return sb.toString();
    }
}
