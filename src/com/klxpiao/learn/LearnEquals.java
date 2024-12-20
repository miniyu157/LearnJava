package com.klxpiao.learn;

import java.util.*;

public class LearnEquals {
    public static void main(String[] args) {
        List<Person> list = List.of(
                new Person("Xiao", "Ming", 18),
                new Person("Xiao", "Hong", 25),
                new Person("Bob", "Smith", 20)
        );
        boolean exist = list.contains(new Person("Bob", "Smith", 20));
        System.out.println(exist ? "测试成功!" : "测试失败!");
    }

    static class Person {
        String firstName;
        String lastName;
        int age;

        public Person(String firstName, String lastName, int age) {
            this.firstName = firstName;
            this.lastName = lastName;
            this.age = age;
        }

        public boolean equals(Object o) {
            if (o instanceof Person p) {
                return firstName.equals(p.firstName) && lastName.equals(p.lastName) && age == p.age;
            }
            return false;
        }
    }
}
