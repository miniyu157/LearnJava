package com.klxpiao.date1124

//不用导入各种命名空间了，和C#一样。


class BubblingSorting {
    /**
     * 对数组进行冒泡排序 (升序)。
     *
     * @param arr      要排序的数组。
     * @param reversal 是否反转排序 (默认为false)。
     */
    fun bubbleSort(
        arr: IntArray,
        reversal: Boolean = false
    ) { //和C#一样支持可选参数。
        for (i in arr.indices) {
            var swapped = false //标记是否发生交换
            for (j in 0 until arr.size - i - 1) { //确定不是抄VB.NET??
                if (reversal == (arr[j] < arr[j + 1])) {
                    val temp = arr[j + 1]
                    arr[j + 1] = arr[j]
                    arr[j] = temp
                    swapped = true
                }
            }
            if (!swapped) break //若没有交换，即数组有序，提前退出
        }
    }
}

fun main() {
    val arr = intArrayOf(45, 96, 85, 32, 14, 25)
    val sorting = BubblingSorting()

    sorting.bubbleSort(arr)
    println("升序排序结果: ${arr.contentToString()}")

    sorting.bubbleSort(arr, true)
    println("降序排序结果: ${arr.contentToString()}")
}
