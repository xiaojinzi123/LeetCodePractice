package 排序.选择排序

import support.randomIntArray
import support.swap
import 排序.TestList1

fun main() {

    val arr1 = randomIntArray()

    println("冒泡排序前：${arr1.joinToString()}")

    // 从小到大
    for (i in 0 until arr1.lastIndex) {
        for (j in i + 1 until arr1. size) {
            if(arr1[i] > arr1[j]) {
                arr1.swap(i, j)
            }
        }
    }

    println("冒泡排序后：${arr1.joinToString()}")

}