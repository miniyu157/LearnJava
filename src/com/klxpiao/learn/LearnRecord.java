package com.klxpiao.learn;

import static java.lang.System.out;

/*
            总结
- 和C#的结构体 (struct)基本相同
- 只不过一个是值类型，一个是引用类型
- 并且不可变 (final)
*/

public class LearnRecord {
    public static void main(String[] args) {
        PointF pf = new PointF(3.5F, 2.8F);
        PointF pf2 = PointF.of(4.6F, 1.7F);
        PointF pf3 = PointF.of(1.414213F);

        out.println(pf);
        out.println(pf2);
        out.println(pf3);

        out.println(pf3.distanceFromOrigin());
    }

    record PointF(float x, float y) {
        /**
         * 以指定的 x 和 y 创建一个 PointF 对象。
         *
         * @param x x 坐标。
         * @param y y 坐标。
         * @return 一个 PointF 对象。
         */
        public static PointF of(float x, float y) { //factory method(工厂方法)
            return new PointF(x, y);
        }

        /**
         * 以指定的 p 创建一个 PointF 对象。
         *
         * @param p x 和 y 坐标。
         * @return 一个 PointF 对象。
         */
        public static PointF of(float p) {
            return new PointF(p, p);
        }

        /**
         * 计算该点到原点的距离。
         *
         * @return 该点到原点的距离。
         */
        public float distanceFromOrigin() {
            return (float) Math.sqrt(x * x + y * y);
        }

        //error! 不能修改属性
//
//        public void setX(float x){
//            this.x = x;
//        }

        /**
         * 自定义构造器，可以加上一些限制，例如限定范围
         */
        public PointF {
//            if (x < 0 || y < 0) {
//                throw new IllegalArgumentException("不允许负数");
//            }
        }
    }
}
