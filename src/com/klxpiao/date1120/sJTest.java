package com.klxpiao.date1120;

//字符串模版在 java23 中被阉割
//import static java.lang.StringTemplate.STR;

public class sJTest {
    public static void main(String[] args) {
        String[] fields = {"name", "position", "salary"};
        String table = "employee";
        String select = buildSelectSql(table, fields);
        System.out.println(select);
        System.out.println("SELECT name, position, salary FROM employee".equals(select) ? "测试成功" : "测试失败");
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

    static String buildSelectSql(String table, String[] fields) {
        return String.format("SELECT %s FORM %s", String.join(", ", fields), table);
        //return "SELECT " + String.join(", ", fields) + " FROM " + table;

        //return java.lang.StringTemplate.STR."SELECT \{String.join(", ", fields)} FROM \{table}";
    }

}
