package 算法.二维数组中的查找

import org.junit.Assert

fun main() {

    val arr: Array<Array<Int>> = arrayOf(
        arrayOf(1, 4, 7, 11, 15),
        arrayOf(2, 5, 8, 12, 19),
        arrayOf(3, 6, 9, 16, 22),
        arrayOf(10, 13, 14, 17, 24),
        arrayOf(18, 21, 23, 26, 30)
    )

    Assert.assertTrue(find(arr, 18) == Pair(4, 0))
    Assert.assertTrue(find(arr, 20) == null)
    Assert.assertTrue(find(arr, 31) == null)

    println("测试通过")

}

private fun find(arr: Array<Array<Int>>, target: Int): Pair<Int, Int>? {
    var x = arr[0].lastIndex
    var y = 0
    while (x >= 0 && y < arr.size) {
        when {
            target == arr[y][x] -> {
                return Pair(y, x)
            }
            target < arr[y][x] -> {
                x--
            }
            else -> {
                y++
            }
        }
    }
    return null
}