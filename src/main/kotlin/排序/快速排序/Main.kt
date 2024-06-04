package 排序.快速排序

import support.randomIntArray
import support.swap

fun quickSort(arr: IntArray, left: Int, right: Int) {
    if (left >= right) return
    var i = left
    var j = right
    val key = arr[left]
    while (i < j) {
        while (i < j && arr[j] >= key) {
            j--
        }
        while (i < j && arr[i] <= key) {
            i++
        }
        arr.swap(i, j)
    }
    arr.swap(left, i)
    // arr[i] = key
    quickSort(arr, left, i - 1)
    quickSort(arr, i + 1, right)
}

fun main() {

    val arr1 = randomIntArray()
    // val arr1 = arrayOf(6, 1, 2, 7, 9, 3, 4, 5, 10, 8).toIntArray()

    println("快速排序前：${arr1.joinToString()}")

    // 快速排序 从小到大
    quickSort(arr = arr1, left = 0, right = arr1.lastIndex)

    println("快速排序后：${arr1.joinToString()}")

}