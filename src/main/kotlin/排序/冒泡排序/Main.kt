package 排序.冒泡排序

import support.randomIntArray
import support.swap

fun main() {

    val arr1 = randomIntArray()

    println("冒泡排序前：${arr1.joinToString()}")

    // 从小到大
    for (i in 0 until arr1.lastIndex) {
        for (j in 0 until arr1.lastIndex - i) {
            if (arr1[j] > arr1[j + 1]) {
                arr1.swap(j, j + 1)
            }
        }
    }

    println("冒泡排序后：${arr1.joinToString()}")

}