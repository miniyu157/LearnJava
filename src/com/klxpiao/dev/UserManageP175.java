package com.klxpiao.dev;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class UserManageP175 {
    private static final Scanner sc = new Scanner(System.in);
    private static final List<UserInfo> USERINFOS;

    static {
        USERINFOS = new ArrayList<>();
        USERINFOS.add(new UserInfo("王二", "女", "25", "13987654321"));
        USERINFOS.add(new UserInfo("张三", "男", "30", "123-874569"));
        USERINFOS.add(new UserInfo("李四", "女", "25", "+8619988765432"));
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
                case "1" -> add(-1);
                case "2" -> query();
                case "3" -> modify();
                case "4" -> delete();
                case "5" -> System.exit(0);
                default -> out.println("输入错误。");
            }
        }
    }

    /**
     * 客户信息。
     *
     * @param name        姓名。
     * @param sex         性别。
     * @param age         年龄。
     * @param phone       电话。
     * @param errorStatus 异常状态，请勿手动设置此属性，自动状态：0为正常，-1错误。
     */
    record UserInfo(String name, String sex, String age, String phone, int... errorStatus) {
        public UserInfo {
            errorStatus = new int[]{0};

            if (!phone.replaceAll("[\\-+]", "").matches("\\d+")) {
                out.println("电话只能由数字、加号和减号组成。");
                errorStatus[0] = -1;
            }

            if (!age.matches("\\d+") || Integer.parseInt(age) < 0) {
                out.println("年龄只能由数字组成，且不能为负数。");
                errorStatus[0] = -1;
            }
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
     * 输入编号。
     *
     * @return 编号。
     */
    static int inputID() {
        int id = -1;
        try {
            id = sc.nextInt();
        } catch (Exception ex) {
            out.println("请输入数字。");
            System.exit(0);
        }

        if (id <= 0 || id > USERINFOS.size()) {
            out.println("编号不存在。");
            System.exit(0);
        }
        return id;
    }

    /**
     * 添加客户信息。
     */
    static void add(int index) {
        out.println(index == -1 ? "客户管理>>添加客户信息\n********************************" : "");

        String[] titles = {"姓名: ", "性别: ", "年龄: ", "电话: "};
        String[] values = new String[4];
        for (int i = 0; i < titles.length; i++) {
            out.print(titles[i]);
            values[i] = sc.next();
        }

        out.println(index == -1 ? "********************************" : "");

        UserInfo u = new UserInfo(values[0], values[1], values[2], values[3]);

        if (u.errorStatus[0] == 0) { //无错误即可添加
            if (index == -1)
                USERINFOS.add(u);
            else
                USERINFOS.set(index, u);

            out.printf("客户 '%s' %s成功!\n", values[0], index == -1 ? "添加" : "修改");
        }
        pressEnterToReturn();
    }

    /**
     * 列举客户信息。
     *
     * @param title 标题。
     */
    static void showUserInfo(String title) {
        out.printf("""
                %s
                ********************************
                编号\t姓名\t性别\t年龄\t电话
                """, title);

        for (int i = 0; i < USERINFOS.size(); i++) {
            UserInfo user = USERINFOS.get(i);
            out.printf("%s\t%s\t%s\t%s\t%s\n", i + 1, user.name, user.sex, user.age, user.phone);
        }
        out.println("********************************");
    }

    /**
     * 查询客户信息。
     */
    static void query() {
        showUserInfo("查询");
        pressEnterToReturn();
    }

    /**
     * 删除客户信息。
     */
    static void delete() {
        showUserInfo("客户管理>>删除客户信息");

        out.print("请选择要删除的客户编号: ");
        USERINFOS.remove(inputID() - 1);

        out.println("删除成功!");
        pressEnterToReturn();
    }

    /**
     * 修改客户信息。
     */
    static void modify() {
        showUserInfo("客户管理>>修改客户信息");

        out.print("请选择要修改的客户编号: ");
        add(inputID() - 1);
    }
}
