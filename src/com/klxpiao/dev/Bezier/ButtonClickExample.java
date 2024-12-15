package com.klxpiao.dev.Bezier;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ButtonClickExample extends JFrame {
    private final int WIDTH = 400;
    private final int HEIGHT = 400;

    public ButtonClickExample() {
        setTitle("Button Click Example");
        setSize(WIDTH, HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // 创建一个按钮
        JButton button = new JButton("Click me!");

        // 为按钮添加ActionListener
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 在这里处理按钮点击事件
                JOptionPane.showMessageDialog(ButtonClickExample.this, "Button clicked!");
                System.exit(0);
            }
        });

        // 将按钮添加到窗口的内容面板中
        getContentPane().add(button, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ButtonClickExample();
            }
        });
    }
}
