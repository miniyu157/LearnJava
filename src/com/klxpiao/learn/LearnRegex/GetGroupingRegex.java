package com.klxpiao.learn.LearnRegex;

import java.util.regex.*;

import static java.lang.System.out;

public class GetGroupingRegex {
    public static void main(String[] args) {
        //分组
        Pattern p = Pattern.compile("(\\d{2}):(\\d{2}):(\\d{2})");
        Matcher m = p.matcher("23:01:59");

        if (m.matches()) {
            out.println(m.group(1));
            out.println(m.group(2));
            out.println(m.group(3));
        } else {
            out.println("匹配失败!");
        }
    }
}
