package com.klxpiao.date1123;

/**
 *  不能直接强转为int
 *  不能手动分配常量值，不过可以写构造函数手动加上枚举成员的属性（例如序号什么的）
 *  获取枚举成员的名字，用.name();
 */
public class LearnEnum {
    public static void main(String[] args) {
//        int dayInt = Weekday.MON.ordinal();
//        if (1 == Weekday.MON.ordinal()) {
//
//        }
//
//        String s = Weekday.SUN.name(); // "SUN"

        Weekday weekday = Weekday.FRI;
        System.out.println(weekday); //toString
    }
}

enum Weekday {
    MON(1, "星期一"),
    TUE(2, "星期二"),
    WED(3, "星期三"),
    THU(4, "星期四"),
    FRI(5, "星期五"),
    SAT(6, "星期六"),
    SUN(0, "星期日");

    public final int dayValue;
    private final String chinese; //调用toString获取

    Weekday(int dayValue, String chinese) {
        this.dayValue = dayValue;
        this.chinese = chinese;
    }

    @Override
    public String toString() {
        return this.chinese;
    }
}

