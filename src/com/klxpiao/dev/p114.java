package com.klxpiao.dev;

import java.util.*;

import static java.lang.System.out;

public class p114 {
    /**
     * Products 产品
     * Product 商品
     * WhetherToContinue 是否继续
     * AmountDue 应付金额
     * AmountPaid 实付金额
     * Inventory 库存
     * Quantities 数量
     */

    //有一个 bug, 输入商品数量为非数字时，执行两次 whetherToContinue 方法。

    private static final Scanner sc = new Scanner(System.in);
    private static final String[] titles = {"商品编号", "商品名称", "商品价格", "商品数量"};
    private static final String[][] products = {
            {"1", "男士衬衫", "570.00", "3"},
            {"2", "裙子", "888.00", "5"},
            {"3", "运动鞋", "500.00", "7"},
            {"4", "运动帽", "300.00", "9"}
    };

    private static String[] product;
    private static int selectID = -1;

    public static void main(String[] args) {
        showAllProductsInfo();                       //显示商品序号和名称
        inputID(args);                               //输入id
        showProductInfo();                           //显示商品信息
        int count = inputCount(args);                //输入数量
        checkout(count, args);                       //结账
        updateInventoryQuantities(selectID, -count); //更新库存
        whetherToContinue(args);                     //询问是否继续
    }

    /**
     * 输入商品编号并尝试查找商品。
     *
     * @param args 传递程序参数。
     */
    static void inputID(String[] args) {
        out.print("\n请输入要购买的商品编号: ");
        String inputIndex = sc.next();

        //检查是否为数字
        try {
            int _ = Integer.parseInt(inputIndex);
        } catch (Exception e) {
            out.println("请输入数字");
            main(args);
        }

        out.println();

        //查找商品
        for (String[] p : products) {
            String id = p[0];
            if (inputIndex.equals(id)) {
                product = p;
                selectID = Integer.parseInt(id);
                break;
            }
        }

        if (product == null) {
            out.println("商品不存在");
            whetherToContinue(args);
        }
    }

    /**
     * 输入数量。
     *
     * @param args 传递程序参数。
     * @return 输入的数量。
     */
    static int inputCount(String[] args) {
        int count = -1;

        try {
            out.print("\n请输入购买数量(输入0取消购买): ");
            count = sc.nextInt();
        } catch (Exception ex) {
            out.println("请输入数字");
            whetherToContinue(args);
        }

        if (count < 0) {
            out.println("数量不能小于0");
            whetherToContinue(args);
        }
        if (count == 0) whetherToContinue(args);
        if (count > Integer.parseInt(product[3])) {
            out.println("商品数量不足");
            whetherToContinue(args);
        }
        return count;
    }

    /**
     * 结账。
     *
     * @param count 购买数量。
     */
    static void checkout(int count, String[] args) {
        double amountDue = count * Double.parseDouble(product[2]);
        out.printf("应付: %.2f%n", amountDue);
        out.print("实付: ");
        double amountPaid = sc.nextDouble();

        if (amountPaid < amountDue) {
            out.println("金额不足");
            whetherToContinue(args);
        }

        out.printf("找钱: %.2f%n", amountPaid - amountDue);
    }

    /**
     * 更新库存数量。
     *
     * @param quantity 要更新的数量。
     */
    static void updateInventoryQuantities(int selectID, int quantity) {
        products[selectID - 1][3] = String.valueOf(Integer.parseInt(products[selectID - 1][3]) + quantity);
    }

    /**
     * 询问是否继续挑选商品。
     *
     * @param args 传递程序参数。
     */
    static void whetherToContinue(String[] args) {
        out.print("\n是否继续挑选商品？(y/n) ");
        String input = sc.next();
        if (input.equalsIgnoreCase("y"))
            main(args);
        else if (input.equalsIgnoreCase("n"))
            System.exit(0);
        else
            whetherToContinue(args);
    }

    /**
     * 显示商品列表。
     */
    static void showAllProductsInfo() {
        Arrays.stream(products).forEach(data -> out.printf("%s.%s\t", data[0], data[1]));
    }

    /**
     * 显示商品信息。
     */
    static void showProductInfo() {
        for (int i = 0; i < titles.length; i++)
            out.printf("%s: %s\n", titles[i], product[i]);
    }
}
