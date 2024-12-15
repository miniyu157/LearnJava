package com.klxpiao.learn.LearnCollection;

import java.util.*;

public class LearnList {
    public static void main(String[] args) {
        //bad

//        List<String> list = List.of("apple", "pear", "banana");
//        for (int i=0; i<list.size(); i++) {
//            String s = list.get(i);
//            System.out.println(s);
//        }

        //good

//        List<String> list = List.of("apple", "pear", "banana");
//        for (Iterator<String> it = list.iterator(); it.hasNext(); ) {
//            String s = it.next();
//            System.out.println(s);
//        }

        //good

//        List<String> list = List.of("apple", "pear", "banana");
//        for (String s : list) {
//            System.out.println(s);
//        }

        //练习：给定一组连续的整数，例如：10，11，12，……，20，但其中缺失一个数字，试找出缺失的数字：
        //增强版：和上述题目一样，但整数不再有序，试找出缺失的数字：

        // 构造从start到end的序列：
        final int start = 10;
        final int end = 20;
        List<Integer> list = new ArrayList<>();
        for (int i = start; i <= end; i++) {
            list.add(i);
        }
        // 洗牌算法shuffle可以随机交换List中的元素位置:
        Collections.shuffle(list);
        // 随机删除List中的一个元素:
        int removed = list.remove((int) (Math.random() * list.size()));
        int found = findMissingNumber(start, end, list);
        System.out.println(list.toString());
        System.out.println("missing number: " + found);
        System.out.println(removed == found ? "测试成功" : "测试失败");
    }

    //O(n^2)
//    static int findMissingNumber(int start, int end, List<Integer> list) {
//        for (int i = start; i <= end; i++)
//            if (!list.contains(i))
//                return i;
//
//        return 0;
//    }

    //O(n)
    static int findMissingNumber(int start, int end, List<Integer> list) {
        int a1 = start;
        int n = end - start + 1;
        int d = 1;
        int expectedSum = a1 * n + (n * d * (n - 1)) / 2;

        int actualSum = list.stream().mapToInt(Integer::intValue).sum();
        return expectedSum - actualSum;
    }
}
