package com.klxpiao.dev.UserManage2;

public record User(String id, String name, String sex, int age, String phone) {
    public User {
        if (age <= 0) throw new IllegalArgumentException("年龄必须大于0。");

        /*
         正则表达式规则：
         ^：匹配字符串的开头。
         \\+?：开头可以有一个加号，最多一个。
         (?!.*--)(?!.*-$)：确保字符串中没有连续的减号（例如--），并且最后一位不是减号。
         [0-9]+(-[0-9]+)*：匹配数字序列，中间可以有减号。
         $：匹配字符串的结尾。

         解析：
         \\+?：允许字符串以加号开头，最多一个。
         (?!.*--)(?!.*-$)：断言，防止连续两个减号或者结尾是减号。
         [0-9]+(-[0-9]+)*：确保数字和减号以正确顺序排列，减号不能连续，且必须夹在数字中间。
         结合开头和结尾符号：保证完整的格式检查。

         测试用例：
         合法：
         +6965465464
         +89102-6569-5693
         102-1256-3658
         1234567890
         +123-456-7890

         非法：
         +--123456 （连续减号）
         123- （结尾是减号）
         +-123456 （加号后紧跟减号）
         ++123456 （多个加号）
         123--456 （连续减号）
        */

        if (!phone.matches("^\\+?(?!.*--)(?!.*-$)[0-9]+(-[0-9]+)*$")) {
            throw new IllegalArgumentException("电话只能由数字、加号和减号组成，或者格式不正确。");
        }
    }

    public static User of(String id, String name, String sex, int age, String phone) {
        return new User(id, name, sex, age, phone);
    }

    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", id, name, sex, age, phone);
    }
}
