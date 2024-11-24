package com.klxpiao.learn;

public class LearnStringJoiner {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FORM employee".equals(select) ? "测试成功" : "测试失败");
    }

/* 使用StringJoiner
    static String buildSelectSql(String table, String[] fields) {
        StringJoiner sj = new StringJoiner(", ", "SELECT ", " FROM " + table);
        for (String s : fields) {
            sj.add(s);
        }

        return sj.toString();

    }
*/

    //使用String.join
    static String buildSelectSql(String table, String[] fields) {
        return String.format("SELECT %s FORM %s", String.join(", ", fields), table);
    }

}
