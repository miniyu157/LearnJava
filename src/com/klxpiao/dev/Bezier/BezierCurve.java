package com.klxpiao.dev.Bezier;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

import static java.lang.System.out;

class BezierCurve {
    
    public static void main(String[] args) {
        Point2D.Float[] controlPoints = {
                new Point2D.Float(0, 0),
                new Point2D.Float(0.15f, 0.85f),
                new Point2D.Float(0.85f, 0.15f),
                new Point2D.Float(1, 1)
        };

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < controlPoints.length - 1; i++) {
            sb.append(String.format("%s, %s", controlPoints[i].x, controlPoints[i].y));
            if (i != controlPoints.length - 2) sb.append(", ");
        }
        out.printf("[%s]\n", sb);

        // 定义图像的宽度和高度
        int width = 20;
        int height = 10;

        // 计算曲线上的点
        List<Point2D.Float> curvePoints = new ArrayList<>();
        for (double t = 0; t <= 1; t += 0.01) {
            Point2D.Float point = calculateBezierPointByTime(t, controlPoints);
            curvePoints.add(point);
        }

        // 创建一个二维数组来表示图像
        char[][] image = new char[height][width];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                image[i][j] = ' ';
            }
        }

        // 将曲线上的点映射到图像上
        for (Point2D.Float point : curvePoints) {
            int x = (int) (point.x * width);
            int y = (int) ((1 - point.y) * height);//转换为数学坐标系
            image[y][x] = '*';
        }

        // 打印图像
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                out.print(image[i][j]);
            }
            out.println();
        }
    }

    /**
     * 根据时间进度计算贝塞尔曲线上的点。
     *
     * @param timeProgress  时间进度，范围在0到1之间。
     * @param controlPoints 控制点数组。
     * @return 贝塞尔曲线上的点。
     */
    public static Point2D.Float calculateBezierPointByTime(double timeProgress, Point2D.Float[] controlPoints) {
        double epsilon = 1e-6;
        double lower = 0.0;
        double upper = 1.0;
        double t = (lower + upper) / 2.0;

        while (upper - lower > epsilon) {
            t = (lower + upper) / 2.0;
            Point2D.Float point = calculateBezierPoint(t, controlPoints);
            double currentProgress = point.getX();

            if (currentProgress < timeProgress) {
                lower = t;
            } else {
                upper = t;
            }
        }
        return calculateBezierPoint(t, controlPoints);
    }

    /**
     * 根据曲线进度计算贝塞尔曲线上的点。
     *
     * @param t             曲线进度，范围在0到1之间。
     * @param controlPoints 控制点数组。
     * @return 贝塞尔曲线上的点。
     */
    public static Point2D.Float calculateBezierPoint(double t, Point2D.Float[] controlPoints) {
        if (controlPoints == null || controlPoints.length == 0) {
            throw new IllegalArgumentException("控制点数组不能为空");
        }

        int n = controlPoints.length - 1;
        return calculateBezierPointRecursive(t, controlPoints, n);
    }

    /**
     * 递归计算贝塞尔曲线上的点。
     *
     * @param t             曲线进度，范围在0到1之间。
     * @param controlPoints 控制点数组。
     * @param n             控制点的数量减一。
     * @return 贝塞尔曲线上的点。
     */
    private static Point2D.Float calculateBezierPointRecursive(double t, Point2D.Float[] controlPoints, int n) {
        if (n == 0) {
            return controlPoints[0];
        }

        Point2D.Float[] reducedPoints = new Point2D.Float[n];
        for (int i = 0; i < n; i++) {
            float x = (float) ((1 - t) * controlPoints[i].x + t * controlPoints[i + 1].x);
            float y = (float) ((1 - t) * controlPoints[i].y + t * controlPoints[i + 1].y);
            reducedPoints[i] = new Point2D.Float(x, y);
        }

        return calculateBezierPointRecursive(t, reducedPoints, n - 1);
    }
}

