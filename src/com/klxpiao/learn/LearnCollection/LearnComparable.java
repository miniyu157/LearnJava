package com.klxpiao.learn.LearnCollection;

import java.util.*;

public class LearnComparable {
    public static void main(String[] args) {
        //TreeSet 是一个有序集合，它使用自然排序来维护元素的顺序。在将对象添加到 TreeSet 中时，会自动调用对象的 compareTo 方法来确定它们的排序位置。
        TreeSet<Student> studentSet = new TreeSet<>();
        studentSet.add(new Student("Alice", 22));
        studentSet.add(new Student("Bob", 20));
        studentSet.add(new Student("Charlie", 25));

        for (Student student : studentSet) {
            System.out.println(student);
        }

        //如果您有一个列表或数组，想要对其中的元素进行排序，可以使用 Collections.sort 方法。这个方法要求列表中的元素必须实现 Comparable 接口。
        List<Student> students = new ArrayList<>();
        students.add(new Student("Alice", 22));
        students.add(new Student("Bob", 20));
        students.add(new Student("Charlie", 25));

        Collections.sort(students);

        for (Student student : students) {
            System.out.println(student);
        }

        Map<String, Integer> map = new TreeMap<>();
        map.put("orange", 1);
        map.put("apple", 2);
        map.put("pear", 3);
        for (String key : map.keySet()) {
            System.out.println(key);
        }
        Arrays.stream(map.keySet().toArray()).forEach(System.out::println);
        Arrays.stream(map.keySet().toArray()).forEach(s -> System.out.println(s));
    }
}

class Student implements Comparable<Student> {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Student other) {
        // 先按年龄升序排序
        int ageComparison = this.age - other.age;
        if (ageComparison != 0) {
            return ageComparison;
        }

        // 如果年龄相等，则按姓名字母顺序排序
        return this.name.compareTo(other.name);
    }

    @Override
    public String toString() {
        return String.format("Student{name='%s', age=%d}", name, age);
    }
}


