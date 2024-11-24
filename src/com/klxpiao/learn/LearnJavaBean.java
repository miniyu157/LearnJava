package com.klxpiao.learn;

public class LearnJavaBean {
    //I declare that the properties of Java are the sons of CSharp
    public static void main(String[] args) throws Exception {

    }

    public class Person {
        private String name;
        private int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
