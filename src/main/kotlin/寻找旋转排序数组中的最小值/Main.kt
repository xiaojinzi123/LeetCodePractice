package 寻找旋转排序数组中的最小值

val test1 = listOf(5, 6, 7, 8, 9, 10, 1, 2, 3, 4)
val test2 = listOf(1, 2, 3, 4)
val test3 = listOf(2, 3, 4, 5, 6, 7, 8, 9, 10, 1)
val test4 = listOf(10, 1, 2, 3, 4, 5, 6, 7, 8, 9)

/**
 * https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/
 */
fun main() {
    assert(Pair(6, 1) == findMin(test1))
    assert(Pair(0, 1) == findMin(test2))
    assert(Pair(9, 1) == findMin(test3))
    assert(Pair(2, 1) == findMin(test4))
    println("通过")
}

/**
 * 寻找最小, 返回下标和对应的值
 * 时间复杂度 O(1)
 */
private fun findMin(list: List<Int>): Pair<Int, Int> {

    var l = 0
    var r = list.size - 1
    while (l < r) {
        // 中间的 index, 靠近 l
        val centerIndex = (l + r) / 2
        if (list[centerIndex] < list[r]) {
            r = centerIndex
        } else if (list[centerIndex] >= list[l]) {
            l = centerIndex + 1
        }
    }
    return Pair(first = l, second = list[l])
}