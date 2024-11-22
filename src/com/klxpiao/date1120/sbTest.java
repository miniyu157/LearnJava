package com.klxpiao.date1120;

import java.util.StringJoiner;

public class sbTest {
    public static void main(String[] args) {
//        String[] fields = { "name", "position", "salary" };
//        String table = "employee";
//        String insert = buildInsertSql(table, fields);
//        System.out.println(insert);
//        String s = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
//        System.out.println(s.equals(insert) ? "测试成功" : "测试失败");

        String[] names = {"Bob", "Alice", "Grace"};
        var sj = new StringJoiner(", ", "Hello ", "!");
        for (String name : names) {
            sj.add(name);
        }
        System.out.println(sj.toString());
    }

    static String buildInsertSql(String table, String[] fields) {
        StringBuilder sql = new StringBuilder("INSERT INTO ");
        sql.append(table).append(" (");
        for (int i = 0; i < fields.length; i++) {
            sql.append(fields[i]);
            if (i < fields.length - 1) {
                sql.append(", ");
            }
        }
        sql.append(") VALUES (?, ?, ?)");
        return sql.toString();
    }

}