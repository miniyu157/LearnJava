package com.klxpiao.dev.Bezier;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Point2D;

public class BezierAnimation extends JFrame {

    private final JPanel movingButton; // 用于动画的按钮
    private final Timer timer; // 动画定时器
    private final Point2D.Float[] controlPoints; // 控制点
    private int animationStep; // 当前动画步骤

    public BezierAnimation() {
        // 初始化窗口
        setTitle("Bezier Curve Animation");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        // 创建按钮
        movingButton = new JPanel();
        movingButton.setBounds(0, 0, 100, 50);
        movingButton.setLayout(null);
        movingButton.setBackground(Color.BLACK);
        add(movingButton);

        // 初始化贝塞尔曲线控制点
        controlPoints = new Point2D.Float[]{
                new Point2D.Float(0, 0),
                new Point2D.Float(0, 300),
                new Point2D.Float(300, 0),
                new Point2D.Float(500, 500)
        };

        // 初始化动画定时器
        animationStep = 0;
        timer = new Timer(16, e -> updateAnimation());
        timer.start();
    }

    /**
     * 更新动画逻辑。
     */
    private void updateAnimation() {
        double t = animationStep / 100.0;
        if (t > 1.0) {
            timer.stop(); // 动画完成后停止定时器
            return;
        }

        // 计算当前贝塞尔曲线上的点
        Point2D.Float point = calculateBezierPoint(t, controlPoints);

        // 更新按钮位置
        movingButton.setBounds((int) point.x, (int) point.y, movingButton.getWidth(), movingButton.getHeight());

        // 增加动画步骤
        animationStep++;
    }

    /**
     * 计算贝塞尔曲线上的点。
     */
    private Point2D.Float calculateBezierPoint(double t, Point2D.Float[] controlPoints) {
        int n = controlPoints.length - 1;
        return calculateBezierPointRecursive(t, controlPoints, n);
    }

    private Point2D.Float calculateBezierPointRecursive(double t, Point2D.Float[] controlPoints, int n) {
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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            BezierAnimation animation = new BezierAnimation();
            animation.setVisible(true);
        });
    }
}

