package com.klxpiao.dev;

import java.util.Arrays;

import static java.lang.System.out;

public class InsertNum {
    public static void main(String[] args) throws Exception {
/* 遍历arr
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] newArr = new int[arr.length + 1];
        int insert = 3;//插入的位置
        boolean flag = false; //是否已插入

        for (int i = 0; i < arr.length; i++) {
            if (i == insert) {
                newArr[i + 1] = arr[i];//将被替换的元素后移一位
                newArr[i] = 100;
                flag = true;
            } else {
                newArr[flag ? i + 1 : i] = arr[i];
            }
        }
*/

/* 遍历newArr
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] newArr = new int[arr.length + 1];
        int insert = 3;//插入的位置

        for (int i = 0; i < newArr.length; i++) {
            if (i < insert) {
                newArr[i] = arr[i];
            } else if (i == insert) {
                newArr[i] = 100;
            } else {
                newArr[i] = arr[i - 1];
            }
        }
*/

//遍历newArr，使用switch表达式
        int[] arr = {1, 2, 3, 4, 5, 6};
        int[] newArr = new int[arr.length + 1];
        int insert = 3;//插入的位置

        for (int i = 0; i < newArr.length; i++) {
            newArr[i] = switch (Integer.compare(i, insert)) { //比较数值大小的方法
                case -1 -> arr[i];    //小于
                case 0 -> 100;        //等于
                case 1 -> arr[i - 1]; //大于
                default -> throw new Exception("出现问题了，但是不可能出现问题");    //不存在的情况
            };
        }

        out.println(Arrays.toString(arr));
        out.println(Arrays.toString(newArr));

    }
}
