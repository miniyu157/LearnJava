package com.klxpiao.date1121;

import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.out;

public class p114 {
    /**
     * Products 产品
     * Product 商品
     * WhetherToContinue 是否继续
     * amountDue 应付金额
     * amountPaid 实付金额
     * Inventory 库存
     * Quantities 数量
     */

    private final Scanner sc = new Scanner(System.in);
    private final String[][] datas = {
            {"1", "男士衬衫", "570.00", "3"},
            {"2", "裙子", "888.00", "5"},
            {"3", "运动鞋", "500.00", "7"},
            {"4", "运动帽", "300.00", "9"}
    };

    private String[] data;
    private int selectID = -1;

    public void main(String[] args) {
        //显示商品序号和名称
        ShowListOfProducts();

        out.print("\n请输入要购买的商品编号: ");
        String inputIndex = sc.next();

        out.println();

        //查找序号
        for (String[] data : datas) {
            String id = data[0];
            if (inputIndex.equals(id)) {
                this.data = data;
                selectID = Integer.parseInt(id); //记录id
                break;
            }
        }
        if (data == null) {
            out.println("商品不存在");
            WhetherToContinue(args);
        }

        //显示商品信息
        ShowProductInfo();

        out.println();

        out.print("请输入购买数量(输入0取消购买): ");
        int count = sc.nextInt();
        if (count == 0)
            WhetherToContinue(args);

        if (count > Integer.parseInt(data[3])) {
            out.println("商品数量不足");
            WhetherToContinue(args);
        }

        double amountDue = count * Double.parseDouble(data[2]);
        out.printf("应付: %.2f%n", amountDue);
        out.print("实付: ");
        double amountPaid = sc.nextDouble();

        if (amountPaid < amountDue) {
            out.println("金额不足");
            WhetherToContinue(args);
        }

        out.printf("找钱: %.2f%n", amountPaid - amountDue);

        //更新库存数量
        UpdateInventoryQuantities(-count);
        WhetherToContinue(args);
    }

    /**
     * 更新库存数量。
     *
     * @param quantity 要更新的数量。
     */
    void UpdateInventoryQuantities(int quantity) {
        datas[selectID - 1][3] = String.valueOf(Integer.parseInt(datas[selectID - 1][3]) + quantity);
    }

    /**
     * 询问是否继续挑选商品。
     *
     * @param args 传递程序参数。
     */
    void WhetherToContinue(String[] args) {
        out.print("\n是否继续挑选商品？(y/n) ");
        String input = sc.next().toLowerCase();
        if (input.equals("y"))
            main(args);
        else if (input.equals("n"))
            System.exit(0);
        else
            WhetherToContinue(args);
    }

    /**
     * 显示商品列表。
     */
    void ShowListOfProducts() {
        Arrays.stream(datas).forEach(data -> out.printf("%s.%s\t", data[0], data[1]));
    }

    /**
     * 显示商品信息。
     */
    void ShowProductInfo() {
        out.printf("商品编号: %s%n", data[0]);
        out.printf("商品名称: %s%n", data[1]);
        out.printf("商品价格: %s%n", data[2]);
        out.printf("商品数量: %s%n", data[3]);
    }
}