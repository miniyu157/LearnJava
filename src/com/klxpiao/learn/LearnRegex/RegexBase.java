package com.klxpiao.learn.LearnRegex;

import java.util.List;

import static java.lang.System.out;

public class RegexBase {
    public static void main(String[] args) {

//        out.println("  sdfsd    ".stripLeading());//去除前面的空格
//        out.println("  sdfsd    ".stripTrailing());
//        out.println("  sdfsd    ".strip());

        //+可以匹配至少一个字符
        //*可以匹配任意个字符，包括0个字符
        //?可以匹配0个或一个字符
        //{n,}就可以匹配至少n个字符
        String regex = "[a-z][a-zA-Z0-9]{2,11}@[a-zA-Z0-9]+\\.[a-zA-Z]{2,6}";
        out.println("klxPiao@elecho.dev".matches(regex));

        String regex1 = "oppoa\\d{2}"; //匹配oppoa[num][num]
        out.println("oppoa14".matches(regex1));

        String regex2 = "\\w+"; //匹配子母、数字、下划线
        out.println("adas454_".matches(regex2));

        String regex3 = "\\s{1,2}"; //匹配空格字符
        out.println("  ".matches(regex3));

        String regex4 = "\\D+"; //匹配非数字
        out.println("原神启动".matches(regex4));


        //练习：请编写一个正则表达式匹配国内的电话号码规则：3~4位区号加7~8位电话，中间用-连接，例如：010-12345678。
        //进阶：国内区号必须以0开头，而电话号码不能以0开头，试修改正则表达式，使之能更精确地匹配。
        String re = "0\\d{2,3}-[1-9]\\d{6,7}";
        for (String s : List.of("010-12345678", "020-9999999", "0755-7654321")) {
            if (!s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        for (String s : List.of("010 12345678", "A20-9999999", "0755-7654.321")) {
            if (s.matches(re)) {
                System.out.println("测试失败: " + s);
                return;
            }
        }
        System.out.println("测试成功!");
    }
}
