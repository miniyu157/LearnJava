package com.klxpiao.learn.LearnRegex;

import java.util.regex.*;

import static java.lang.System.out;

public class UseRegexSearchReplace {
    public static void main(String[] args) {
        regexSplit();
        regexFind();
        regexReplace();
        regexInvertTheReference();

        String originalString = "    ecfds    ssdf   sfsdf    sfsdfsd sdfsdf   ";
        String regex = "\\s+";
        String newString = originalString.replaceAll(regex, " ").strip();

        out.println(newString);
    }

    /**
     * 分割
     */
    static void regexSplit() {
        String[] arr1 = "a b c".split("\\s"); // { "a", "b", "c" }
        String[] arr2 = "a b  c".split("\\s"); // { "a", "b", "", "c" }
        String[] arr3 = "a, b ;; c".split("[,;\\s]+"); // { "a", "b", "c" }

        out.println(String.join("|", arr1));
        out.println(String.join("|", arr2));
        out.println(String.join("|", arr3));
    }

    /**
     * 查找
     */
    static void regexFind() {
        String s = "the quick brown fox jumps over the lazy dog.";
        Pattern p = Pattern.compile("\\wo\\w");   // 匹配o前面和后面都是常用字符的单词
        Matcher m = p.matcher(s);
        while (m.find()) {
            String sub = s.substring(m.start(), m.end());
            out.println(sub);
        }
        m.reset(); // 重置Matcher对象
    }

    /**
     * 替换
     */
    static void regexReplace() {
        String s = "The     quick\t\t brown   fox  jumps   over the  lazy dog.";
        String r = s.replaceAll("\\s+", " ");
        System.out.println(r); // "The quick brown fox jumps over the lazy dog."
    }

    /**
     * 反向引用
     */
    static void regexInvertTheReference() {
        String s = "the quick brown fox jumps over the lazy dog.";
        //我们传入的第二个参数可以使用$1、$2来反向引用匹配到的子串
        String r = s.replaceAll("\\s([a-z]{4})\\s", " <b>$1</b> ");
        System.out.println(r);
    }
}
