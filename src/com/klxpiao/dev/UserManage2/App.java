package com.klxpiao.dev.UserManage2;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Consumer;

import static java.lang.System.out;

public class App {
    static Map<String, User> allUsers = new HashMap<>();
    static UserManage userManage = new UserManage(allUsers);
    static final Scanner sc = new Scanner(System.in);

    static {
        try {
            userManage.addUsers(
                    User.of("001", "张三", "男", 20, "+99548542"),
                    User.of("002", "李四", "女", 25, "101-5136-5898"),
                    User.of("003", "王五", "男", 30, "+861-234901")
            );
        } catch (Exception e) {
            out.println("系统初始化错误。");
            System.exit(0);
        }
    }

    @SuppressWarnings("all") //屏蔽两个无意义的警告
    public static void main(String[] args) {
        while (true) {
            out.print("""
                    用户管理系统
                    \t1. 添加用户
                    \t2. 查询用户
                    \t3. 修改用户
                    \t4. 删除用户
                    \t5. 退出系统
                    """);
            out.print("请选择(1-5): ");

            switch (sc.next()) {
                case "1" -> add();
                case "2" -> query();
                case "3" -> modify();
                case "4" -> delete();
                case "5" -> exit();
                default -> {
                    continue;
                }
            }

            out.println("按任意键回车继续...");
            sc.next();
        }
    }

    static User geUserOfKeyboard() {
        String[] titles = {"ID: ", "姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[titles.length];
        for (int i = 0; i < titles.length; i++) {
            out.printf(titles[i]);
            values[i] = sc.next();
        }
        User user;
        try {
            user = User.of(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]);
        } catch (NumberFormatException e) {
            out.println("年龄必须为数字。");
            return User.Empty;
        } catch (User.UserCreateError e) {
            out.println(e.getMessage());
            return User.Empty;
        }

        return user;
    }

    static void add() {
        showAllUser();
        out.println("用户管理系统 => 添加用户");
        processUserOperation(userManage::add);
    }

    static void modify() {
        showAllUser();
        out.println("用户管理系统 => 修改用户");
        processUserOperation(userManage::modify);
    }

    private static void processUserOperation(Consumer<User> operation) {
        User user = geUserOfKeyboard();
        if (user == User.Empty) return;
        try {
            operation.accept(user);
            out.printf("用户'%s'操作成功。\n", user.id());
        } catch (RuntimeException ex) {
            out.println(ex.getMessage());
        }
    }

    static void delete() {
        showAllUser();
        out.println("用户管理系统 => 删除用户");
        out.print("请输入要删除的用户ID: ");
        String id = sc.next();
        try {
            userManage.delete(id);
        } catch (RuntimeException e) {
            out.println(e.getMessage());
            return;
        }
        out.printf("用户'%s'删除成功。\n", id);
    }

    static void query() {
        out.println("用户管理系统 => 查询用户");
        out.println("ID\t姓名\t性别\t年龄\t电话");
        showAllUser();
    }

    static void exit() {
        out.println("用户管理系统 => 退出系统");
        while (true) {
            out.print("确实要退出系统吗？(y/n): ");
            String answer = sc.next();
            if (answer.equalsIgnoreCase("y")) {
                out.println("退出系统。");
                System.exit(0);
            } else if (answer.equalsIgnoreCase("n")) {
                break;
            }
        }
    }

    static void showAllUser() {
        allUsers.forEach((_, user) -> out.println(user));
    }
}
