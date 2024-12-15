package com.klxpiao.dev.UserManage2;

import java.util.*;

import static java.lang.System.out;

class App {
    static Map<String, User> allUsers = new HashMap<>();
    static UserManage userManage = new UserManage(allUsers);
    static final Scanner sc = new Scanner(System.in);

    static {
        try {
            userManage.addRange(
                    User.of("001", "张三", "男", 20, "+99548542"),
                    User.of("002", "李四", "女", 25, "101-5136-5898"),
                    User.of("003", "王五", "男", 30, "+861-234901")
            );
        } catch (Exception e) {
            out.println("系统初始化错误。");
            System.exit(0);
        }
    }

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
                default -> out.println("输入错误");
            }

            out.println("按任意键回车继续...");
            sc.next();
        }
    }

    static void add() {
        out.println("用户管理系统 => 添加用户");
        String[] titles = {"ID: ", "姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[titles.length];
        for (int i = 0; i < titles.length; i++) {
            out.printf(titles[i]);
            values[i] = sc.next();
        }
        try {
            userManage.add(User.of(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]));
        } catch (NumberFormatException e) {
            out.println("年龄必须为数字。");
            return;
        } catch (Exception e) {
            out.println(e.getMessage());
            return;
        }
        out.printf("用户'%s'添加成功。", values[0]);
    }


    static void query() {
        out.println("用户管理系统 => 查询用户");
        out.println("ID\t姓名\t性别\t年龄\t电话");
        showAllUser();
    }

    static void showAllUser() {
        allUsers.forEach((id, user) -> out.println(user));
    }

    static void modify() {
        out.println("用户管理系统 => 修改用户");
        showAllUser();
        String[] titles = {"ID: ", "姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[titles.length];
        for (int i = 0; i < titles.length; i++) {
            out.printf(titles[i]);
            values[i] = sc.next();
        }
        try {
            userManage.modify(User.of(values[0], values[1], values[2], Integer.parseInt(values[3]), values[4]));
        } catch (NumberFormatException e) {
            out.println("年龄必须为数字。");
            return;
        } catch (Exception e) {
            out.println(e.getMessage());
            return;
        }
        out.printf("用户'%s'修改成功。\n", values[0]);
    }

    static void delete() {
        out.println("用户管理系统 => 删除用户");
        showAllUser();
        out.print("请输入要删除的用户ID: ");
        String id = sc.next();
        try {
            userManage.delete(id);
        } catch (Exception e) {
            out.println(e.getMessage());
            return;
        }
        out.printf("用户'%s'删除成功。\n", id);
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
}

public class UserManage {
    protected final Map<String, User> allUsers;

    public UserManage(Map<String, User> allUsers) {
        this.allUsers = allUsers;
    }

    public void addRange(User... users) throws Exception {
        for (User user : users) {
            add(user);
        }
    }

    public void add(User user) throws Exception {
        if (allUsers.containsKey(user.id()))
            throw new Exception("用户ID已存在。");

        allUsers.put(user.id(), user);
    }

    public void delete(String id) {
        if (!allUsers.containsKey(id))
            throw new RuntimeException("用户ID不存在。");

        allUsers.remove(id);
    }

    public void modify(User user) {
        if (!allUsers.containsKey(user.id()))
            throw new RuntimeException("用户ID不存在。");

        allUsers.put(user.id(), user);
    }
}
