package com.klxpiao.learn.LearnMath;

import java.math.*;

import static java.lang.System.*;

public class LearnBigInteger {
    public static void main(String[] args) {
        BigInteger bi = new BigInteger("123456789");
        BigInteger bi2 = new BigInteger("111111111111111111111111111111111");

        out.println(bi.pow(10).add(bi2));

        long i = bi2.intValue();
        out.println(i);
    }
}
