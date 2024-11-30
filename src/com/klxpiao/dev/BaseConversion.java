package com.klxpiao.dev;

import java.util.HashMap;
import java.util.Map;

/**
 * 提供进制转换方法的实用工具类。
 */
public class BaseConversion {
    /**
     * 用于表示支持的字符集，从数字0到数字9和字母A到Z。
     * 适用于进制转换中的数字表示。
     */
    private static final char[] BASECHARS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    /**
     * 用于将字符映射到其对应的值的映射表。
     * 适用于进制转换中的字符到数值的映射。
     */
    private static final Map<Character, Integer> CHAR_TO_VALUE_MAP = new HashMap<>();

    static {
        for (int i = 0; i < BASECHARS.length; i++)
            CHAR_TO_VALUE_MAP.put(BASECHARS[i], i);
    }

    /**
     * 将指定进制的字符串表示转换为另一个进制的字符串表示，并允许指定前缀。
     *
     * @param str     要转换的字符串。
     * @param oldBase 源进制（范围：2到36）。
     * @param newBase 目标进制（范围：2到36）。
     * @param prefix  转换结果的前缀。
     * @return 转换后的字符串表示，包含前缀。
     * @throws IllegalArgumentException 如果源进制或目标进制不在2到36范围内抛出异常。
     */
    public static String baseConversion(String str, int oldBase, int newBase, String... prefix) throws IllegalArgumentException {
        if (oldBase < 2 || oldBase > 36 || newBase < 2 || newBase > 36)
            throw new IllegalArgumentException("base must be between 2 and 36");

        int dec = baseConversion(str, oldBase);
        String baseStr = baseConversion(dec, newBase);

        String prefixStr = prefix.length == 0 ? "" : prefix[0];
        return String.format("%s%s", prefixStr, baseStr);
    }

    /**
     * 将指定进制的字符串表示转换为十进制整数。
     *
     * @param str  要转换的字符串。
     * @param base 源进制（范围：2到36）。
     * @return 转换后的十进制数值。
     * @throws IllegalArgumentException 如果源进制不在2到36范围内抛出异常。
     */
    public static int baseConversion(String str, int base) throws IllegalArgumentException {
        if (base < 2 || base > 36) throw new IllegalArgumentException("base must be between 2 and 36");

        int dec = 0;

        for (int i = 0; i < str.length(); i++)
            dec += CHAR_TO_VALUE_MAP.get(str.charAt(i)) * (int) Math.pow(base, str.length() - 1 - i);

        return dec;
    }

    /**
     * 将十进制整数转换为指定进制的字符串表示，并允许指定前缀。
     *
     * @param dec    十进制数值。
     * @param base   目标进制（范围：2到36）。
     * @param prefix 转换结果的前缀。
     * @return 转换后的字符串表示，包含前缀。
     * @throws IllegalArgumentException 如果目标进制不在2到36范围内抛出异常。
     */
    public static String baseConversion(int dec, int base, String... prefix) throws IllegalArgumentException {
        String prefixStr = prefix.length == 0 ? "" : prefix[0];

        if (base < 2 || base > 36) throw new IllegalArgumentException("base must be between 2 and 36");

        if (dec <= 0) return String.format("%s0", prefixStr);

        StringBuilder baseStr = new StringBuilder();
        while (dec > 0) {
            baseStr.append(BASECHARS[dec % base]);
            dec /= base;
        }
        return String.format("%s%s", prefixStr, baseStr.reverse());
    }
}
