package com.klxpiao.learn.LearnMath;

import java.util.*;

import static java.lang.System.out;

/**
 * Java标准库还提供了一个StrictMath，它提供了和Math几乎一模一样的方法。
 * 这两个类的区别在于，由于浮点数计算存在误差，不同的平台（例如x86和ARM）计算的结果可能不一致（指误差不同），
 * 因此，StrictMath保证所有平台计算结果都是完全相同的，而Math会尽量针对平台优化计算速度，
 * 所以，绝大多数情况下，使用Math就足够了。
 */
public class LearnMath {
    public static void main(String[] args) {
        //ascii to hex
        byte[] data = "Hello".getBytes();
        HexFormat hf = HexFormat.ofDelimiter(" ").withPrefix("0x").withUpperCase();
        String s = hf.formatHex(data); // 0x48 0x65 0x6C 0x6C 0x6F
        out.println(s);

        //dec to hex
        int original = 12345678;
        out.printf("Custom: %s\n", customToHex(original));
        out.printf("Integer.toHexString: %s\n", Integer.toHexString(original));
    }

    static String customToHex(int n) {
        StringBuilder hexString = new StringBuilder();
        char[] chars = "0123456789ABCDEF".toCharArray();

        while (n > 0) {
            hexString.insert(0, chars[n % 16]);
            n /= 16;
        }
        return String.format("0x%s", hexString);
    }

}
