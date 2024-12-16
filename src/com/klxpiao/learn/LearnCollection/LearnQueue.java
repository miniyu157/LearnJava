package com.klxpiao.learn.LearnCollection;

import java.util.*;

import static java.lang.System.out;

public class LearnQueue {
    public static void main(String[] args) {
        Queue<String> q = new LinkedList<>();
        // 添加3个元素到队列:
        q.offer("apple");
        q.offer("pear");
        q.offer("banana");

        // 队首永远都是apple，因为peek()不会删除它:
        out.println(q.peek()); // apple
        out.println(q.peek()); // apple
        out.println(q.peek()); // apple

        // 从队列取出元素:
        out.println(q.poll()); // apple
        out.println(q.poll()); // pear
        out.println(q.poll()); // banana
        out.println(q.poll()); // null,因为队列是空的

        //q.offer(); 添加元素，不抛出异常
        //q.poll(); 取出元素，不抛出异常
        //q.peek(); 取出元素，但不删除
        //q.add(); 添加元素，抛出异常
        //q.remove(); 取出元素，抛出异常
    }
}
