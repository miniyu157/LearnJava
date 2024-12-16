package com.klxpiao.dev.UserManage2;

/**
 * 记录类，用于存储用户信息。
 *
 * @param id    用户的唯一标识（ID）。
 * @param name  用户的姓名。
 * @param sex   用户的性别。
 * @param age   用户的年龄。
 * @param phone 用户的电话号码。
 */
public record User(String id, String name, String sex, int age, String phone) {
    /**
     * 静态字段，表示一个空的用户对象（等同于 null）。
     */
    public static User Empty = null;

    /**
     * 主构造方法的验证逻辑。
     * 验证用户的年龄和电话号码格式是否正确。
     *
     * @throws UserCreateError 年龄小于等于 0 或电话号码格式不正确时抛出。
     */
    public User {
        if (age <= 0) throw new UserCreateError("年龄必须大于0。");

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
            throw new UserCreateError("电话只能由数字、加号和减号组成，或者格式不正确。");
        }
    }

    /**
     * 静态工厂方法，用于创建一个新的用户对象。
     *
     * @param id    用户的唯一标识（ID）。
     * @param name  用户的姓名。
     * @param sex   用户的性别。
     * @param age   用户的年龄。
     * @param phone 用户的电话号码。
     * @return 一个新的 User 对象。
     */
    public static User of(String id, String name, String sex, int age, String phone) {
        return new User(id, name, sex, age, phone);
    }

    /**
     * 重写的 toString 方法，用于生成用户信息的字符串表示。
     * 输出格式为：id name sex age phone
     *
     * @return 用户信息的字符串表示。
     */
    @Override
    public String toString() {
        return String.format("%s\t%s\t%s\t%s\t%s", id, name, sex, age, phone);
    }

    /**
     * 非受检异常。
     */
    static class UserCreateError extends RuntimeException {
        public UserCreateError(String message) {
            super(message);
        }
    }
}

