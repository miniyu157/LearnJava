package com.klxpiao.date1118;

public class LearnAbstract {
    public static void main(String[] args) {
        // 创建 Circle 对象并显示面积
        Shape circle = new Circle(5);
        circle.DisplayArea();

        // 创建 Rectangle 对象并显示面积
        Shape rectangle = new Rectangle(4, 6);
        rectangle.DisplayArea();
    }
}

class Circle extends Shape {
    private final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    public double CalculateArea() {
        return Math.PI * radius * radius;
    }
}


class Rectangle extends Shape {
    private final double width;
    private final double height;

    public Rectangle(double width, double height) {
        this.width = width;
        this.height = height;
    }

    // 实现抽象方法 CalculateArea
    public double CalculateArea() {
        return width * height;
    }
}

abstract class Shape {
    public abstract double CalculateArea();

    public void DisplayArea() {
        System.out.println("The area of the shape is: " + CalculateArea());
    }
}