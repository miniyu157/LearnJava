package com.klxpiao.learn.LearnRegex;

public class GroupingRegex {
    public static void main(String[] args) {
        //多行匹配时，我们用^表示开头，$表示结尾

        // | 或
        String re = "java|php";
        System.out.println("java".matches(re));
        System.out.println("php".matches(re));
        System.out.println("go".matches(re));

        //匹配 learn java、learn php和learn go
        //learn\sjava|learn\sphp|learn\sgo
        String re2 = "learn\\s(java|php|go)";
        System.out.println("learn java".matches(re2));
        System.out.println("learn Java".matches(re2));
        System.out.println("learn php".matches(re2));
        System.out.println("learn Go".matches(re2));

        //[^范围]{3} 表示匹配3个范围外的字符
    }
}
