package com.klxpiao.learn.LearnCollection;

import java.util.*;

import static java.lang.System.out;

public class LearnPriorityQueue {
    public static void main(String[] args) {
        Queue<User> q = new PriorityQueue<>(new UserComparator());
        // 添加3个元素到队列:
        q.offer(new User("Bob", "A1"));
        q.offer(new User("Alice", "A2"));
        q.offer(new User("Boss", "V1"));
        out.println(q.poll()); // Boss/V1
        out.println(q.poll()); // Bob/A1
        out.println(q.poll()); // Alice/A2
        out.println(q.poll()); // null,因为队列为空
    }
}

class UserComparator implements Comparator<User> {
    public int compare(User u1, User u2) {
        if (u1.number.charAt(0) == u2.number.charAt(0)) {
            //如果两个人地位相同，则比较号码
            return u1.number.compareTo(u2.number);
        }
        // u1的号码是V开头,优先级高:
        return u1.number.charAt(0) == 'V' ? -1 : 1;
    }
}

class User {
    public final String name;
    public final String number;

    public User(String name, String number) {
        this.name = name;
        this.number = number;
    }

    public String toString() {
        return name + "/" + number;
    }
}