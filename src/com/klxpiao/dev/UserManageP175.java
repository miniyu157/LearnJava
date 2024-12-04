package com.klxpiao.dev;

import java.util.*;

import static java.lang.System.out;

public class UserManageP175 {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<UserInfo> AllUser = new ArrayList<>();

    static {
        String[][] users = {
                {"王二", "女", "25", "13987654321"},
                {"张三", "男", "38", "+8612345678910"},
                {"李四", "女", "25", "+01100-12345"}
        };
        addArrays(users);
    }

    public static void main(String[] args) {
        while (true) {
            out.print("""
                    3X购物管理系统>>管理员登录>客户管理
                    ********************************
                    \t1. 添加客户信息
                    \t2. 查询客户信息
                    \t3. 修改客户信息
                    \t4. 删除客户信息
                    \t5. 返回
                    ********************************
                    """);
            out.print("请选择: ");

            switch (sc.next()) {
                case "1" -> add();
                case "2" -> query();
                case "3" -> modify();
                case "4" -> delete();
                case "5" -> exit();
                default -> out.println("输入错误。");
            }
        }
    }

    /**
     * 客户信息。
     *
     * @param name  姓名。
     * @param sex   性别。
     * @param age   年龄。
     * @param phone 电话。
     */
    record UserInfo(String name, String sex, String age, String phone) {
        public static UserInfo Empty = null;

        public UserInfo {
            if (!phone.replaceAll("[\\-+]", "").matches("\\d+")) {
                throw new IllegalArgumentException("电话只能由数字、加号和减号组成。");
            }

            if (!age.matches("\\d+") || Integer.parseInt(age) < 0) {
                throw new IllegalArgumentException("年龄只能由数字组成，且不能为负数。");
            }
        }
    }

    /**
     * 退出系统。
     */
    static void exit() {
        out.print("确定要退出系统吗？(Y/N)");
        if (sc.next().equalsIgnoreCase("y")) {
            out.println("退出系统。");
            System.exit(0);
        }
    }

    /**
     * 按任意键回车返回。
     */
    static void pressEnterToReturn() {
        out.println("按任意键回车返回...");
        String _ = sc.next();
    }

    /**
     * 使用二维数组添加用户信息。
     *
     * @param users 添加用户信息的二维数组。
     */
    static void addArrays(String[][] users) {
        Arrays.stream(users).forEach(u -> AllUser.add(new UserInfo(u[0], u[1], u[2], u[3])));
    }

    /**
     * 删除用户信息。
     *
     * @param index 要删除的用户索引。
     */
    static void removeUser(int index) {
        if (index < 0 || index >= AllUser.size())
            throw new IndexOutOfBoundsException("未找到。");
        AllUser.remove(index);
    }

    /**
     * 列举客户信息。
     */
    static void showUserInfo() {
        out.println("编号\t姓名\t性别\t年龄\t电话");

        for (int i = 0; i < AllUser.size(); i++) {
            UserInfo user = AllUser.get(i);
            out.printf("%s\t%s\t%s\t%s\t%s\n", i + 1, user.name, user.sex, user.age, user.phone);
        }
    }

    /**
     * 输入用户信息。
     *
     * @return 新的 UserInfo 对象。
     */
    static UserInfo inputUserInfo() {
        String[] titles = {"姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[4];
        for (int i = 0; i < titles.length; i++) {
            out.print(titles[i]);
            values[i] = sc.next();
        }
        return new UserInfo(values[0], values[1], values[2], values[3]);
    }

    /**
     * 添加客户信息。
     */
    static void add() {
        out.println("客户管理>>添加客户信息\n********************************");
        String message;
        try {
            UserInfo u = inputUserInfo();
            AllUser.add(u);
            message = String.format("客户 '%s' 添加成功!\n", u.name);
        } catch (Exception ex) {
            message = ex.getMessage();
        }

        out.println(message);
        pressEnterToReturn();
    }

    /**
     * 修改客户信息。
     */
    static void modify() {
        out.println("客户管理>>修改客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToReturn();
            return;
        }

        showUserInfo();
        out.print("请选择要修改的客户编号: ");
        try {
            int id = sc.nextInt();
            UserInfo u = inputUserInfo();
            AllUser.set(id - 1, u);
            out.printf("客户 '%s' 修改成功!\n", u.name);
        } catch (InputMismatchException ex) {
            out.println("请输入数字。");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        pressEnterToReturn();
    }

    /**
     * 查询客户信息。
     */
    static void query() {
        out.println("客户管理>>查询客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToReturn();
            return;
        }

        showUserInfo();

        pressEnterToReturn();
    }

    /**
     * 删除客户信息。
     */
    static void delete() {
        out.println("客户管理>>删除客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToReturn();
            return;
        }
        showUserInfo();

        out.print("请选择要删除的客户编号: ");
        try {
            removeUser(sc.nextInt() - 1);
            out.println("删除成功!");
        } catch (InputMismatchException ex) {
            out.println("请输入数字。");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }

        pressEnterToReturn();
    }
}
