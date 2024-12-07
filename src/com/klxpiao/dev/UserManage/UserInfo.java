package com.klxpiao.dev.UserManage;

import java.util.Scanner;

import static java.lang.System.out;

public record UserInfo(String name, String sex, String age, String phone) {
    public static UserInfo Empty = null;

    public UserInfo {
        if (!phone.replaceAll("[\\-+]", "").matches("\\d+")) {
            throw new IllegalArgumentException("电话只能由数字、加号和减号组成。");
        }

        if (!age.matches("\\d+") || Integer.parseInt(age) < 0) {
            throw new IllegalArgumentException("年龄只能由数字组成，且不能为负数。");
        }
    }

    public static UserInfo ofKeyboard() {
        Scanner sc = new Scanner(System.in);
        String[] titles = {"姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[4];
        for (int i = 0; i < titles.length; i++) {
            out.print(titles[i]);
            values[i] = sc.next();
        }
        return new UserInfo(values[0], values[1], values[2], values[3]);
    }
}
