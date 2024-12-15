package com.klxpiao.dev.UserManage;

import java.util.*;

import static java.lang.System.out;

public class UserManageP175 extends UserManageBase<UserInfo> {
    private static final List<UserInfo> AllUser = new ArrayList<>();
    private static final Scanner sc = new Scanner(System.in);

    static {
        String[][] users = {
                {"王二", "女", "25", "13987654321"},
                {"张三", "男", "38", "+8612345678910"},
                {"李四", "女", "25", "+01100-12345"}
        };
        addArrays(users);
    }

    /**
     * 使用数组添加用户。
     *
     * @param users 用户信息数组。
     */
    private static void addArrays(String[][] users) {
        Arrays.stream(users).forEach(u -> AllUser.add(UserInfo.of(u[0], u[1], u[2], u[3])));
    }

    /**
     * 构造函数。
     *
     * @param allUsers 所有用户信息。
     */
    public UserManageP175(List<UserInfo> allUsers) {
        super(allUsers);
    }

    public static void main(String[] args) {
        UserManageP175 userManager = new UserManageP175(AllUser);

        Runnable exit = () -> {
            System.out.print("确定要退出系统吗? (y/n) ");
            if (sc.next().equalsIgnoreCase("y")) {
                out.println("退出系统。");
                System.exit(0);
            }
        };

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
                case "1" -> userManager.add();
                case "2" -> userManager.query();
                case "3" -> userManager.modify();
                case "4" -> userManager.delete();
                case "5" -> exit.run();
                default -> out.println("输入错误。");
            }
        }
    }

    @Override
    public void add() {
        out.println("客户管理>>添加客户信息\n********************************");
        String message;
        try {
            UserInfo u = UserInfo.ofKeyboard();
            AllUser.add(u);
            message = String.format("客户 '%s' 添加成功!\n", u.name());
        } catch (IllegalArgumentException ex) {
            message = ex.getMessage();
        }
        out.println(message);
        pressEnterToContinue();
    }

    @Override
    public void query() {
        out.println("客户管理>>查询客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToContinue();
            return;
        }

        showUserInfo();

        pressEnterToContinue();
    }

    @Override
    public void modify() {
        out.println("客户管理>>修改客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToContinue();
            return;
        }

        showUserInfo();
        out.print("请选择要修改的客户编号: ");
        try {
            int index = inputID();
            String oldName = AllUser.get(index).name();
            UserInfo u = UserInfo.ofKeyboard();
            AllUser.set(index, u);
            out.printf("客户 '%s' 修改成功!\n", oldName);
        } catch (InputMismatchException ex) {
            out.println("请输入数字。");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        pressEnterToContinue();
    }

    @Override
    public void delete() {
        out.println("客户管理>>删除客户信息\n********************************");

        if (AllUser.isEmpty()) {
            out.println("暂无客户信息。");
            pressEnterToContinue();
            return;
        }
        showUserInfo();

        out.print("请选择要删除的客户编号: ");
        try {
            int index = inputID();
            String oldName = AllUser.get(index).name();
            allUsers.remove(index);
            out.printf("客户 '%s' 删除成功!\n", oldName);
        } catch (InputMismatchException ex) {
            out.println("请输入数字。");
        } catch (Exception ex) {
            out.println(ex.getMessage());
        }
        pressEnterToContinue();
    }

    /**
     * 输入用户编号。
     *
     * @return 返回索引。
     */
    static int inputID() {
        int index = sc.nextInt() - 1;
        if (index < 0 || index >= AllUser.size())
            throw new IndexOutOfBoundsException("未找到。");
        return index;
    }

    static void pressEnterToContinue() {
        out.println("按任意键回车继续...");
        sc.next();
    }

    static void showUserInfo() {
        out.println("编号\t姓名\t性别\t年龄\t电话");
        for (int i = 0; i < AllUser.size(); i++) {
            UserInfo user = AllUser.get(i);
            out.printf("%d\t%s\t%s\t%s\t%s\n", i + 1, user.name(), user.sex(), user.age(), user.phone());
        }
    }
}
