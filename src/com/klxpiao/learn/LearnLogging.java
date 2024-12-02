package com.klxpiao.learn;

import com.sun.tools.javac.Main;

import java.nio.charset.StandardCharsets;
import java.util.logging.Logger;

import static java.lang.System.out;

public class LearnLogging {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(Main.class.getName());
        logger.info("Start process...");

        try {
            int _ = Integer.parseInt("x");
        } catch (Exception e) {
            // 使用logger.severe()打印异常
            logger.severe("UnsupportedEncodingException occurred: " + e.getMessage());
        }
        logger.info("Process end.");

        byte[] bytes = "原神启动".getBytes(StandardCharsets.UTF_8);
        out.println(new String(bytes));

    }

}
