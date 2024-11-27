package com.klxpiao.learn.LearnRegex;

import java.util.regex.*;

public class CrazyRegex {
    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("(\\d+?)(0*)"); //?表示非贪婪匹配
        Matcher matcher = pattern.matcher("1230000");
        if (matcher.matches()) {
            System.out.println("group1=" + matcher.group(1)); // "123"
            System.out.println("group2=" + matcher.group(2)); // "0000"
        }

    }
}
