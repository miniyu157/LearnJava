package com.klxpiao.dev;

import java.util.Arrays;

import static java.lang.System.out;

public class BubblingSorting {
    public static void main(String[] args) {
        int[] arr = {45, 96, 85, 32, 14, 25};

        bubbleSort(arr);
        out.println(Arrays.toString(arr));

        bubbleSort(arr, true);
        out.println(Arrays.toString(arr));
    }

    /**
     * 对数组进行冒泡排序 (升序)。
     *
     * @param arr      要排序的数组。
     * @param reversal 是否反转排序 (默认为false)。
     */
    public static void bubbleSort(int[] arr, boolean... reversal) {
        boolean isReversal = reversal.length != 0 && reversal[0];

        for (int i = 0; i < arr.length; i++) {
            boolean swapped = false; //标记是否发生交换
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (isReversal == (arr[j] < arr[j + 1])) {
                    int temp = arr[j + 1];
                    arr[j + 1] = arr[j];
                    arr[j] = temp;
                    swapped = true;
                }
            }
            if (!swapped) break; //若没有交换，即数组有序，提前退出
        }
    }
}
