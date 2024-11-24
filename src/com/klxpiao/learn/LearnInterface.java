package com.klxpiao.learn;

enum GameEnum {
    GenshinImpact,
    Phigros
}
public class LearnInterface {
    public static void main(String[] args) {
        ThisGame = GameEnum.Phigros;


        GetGameName getName = new GetGameName();
        String name = getName.GetName();
        System.out.println(name);
    }

    public static GameEnum ThisGame;
}

interface IGetName {
    String GetName();
}

class GetGameName implements IGetName {
    @Override
    public String GetName() {
        return switch (LearnInterface.ThisGame) {
            case GameEnum.GenshinImpact -> "原神";
            case GameEnum.Phigros -> "屁股肉";
        };
    }
}

interface Person {
    String getName();
    default void run() {
        System.out.println(getName() + " run");
    }
}

class Student implements Person {
    private String name;

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }
}