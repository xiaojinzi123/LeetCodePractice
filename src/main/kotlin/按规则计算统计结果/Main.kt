package 按规则计算统计结果

import org.junit.Assert

/**
 * 看解答中的图片, 每一项 b[i] 展开就是 a[0] * a[1] * ... * a[i - 1] * a[i + 1] * ... * a[n - 1]
 * 如果一次追求结果, 那么和暴力破解没两样.
 * 从表格中可以观察出. 我们可以计算每一个 b[i] 的前面一部分 a[0] * a[1] * ... * a[i - 1]
 * 这样子每一个 b[i] 在第一次计算中, 就是 a[0] * a[1] * ... * a[i - 1]
 */
private fun statisticalResult(arrayA: IntArray): IntArray {
    val b = IntArray(arrayA.size)
    if (arrayA.isEmpty()) {
        return b
    }
    b[0] = 1
    for (index in (1..arrayA.lastIndex)) {
        b[index] = b[index - 1] * arrayA[index - 1]
    }
    var temp = 1
    for(index in (arrayA.lastIndex - 1) downTo 0) {
        temp *= arrayA[index + 1]
        b[index] = b[index] * temp
    }
    return b
}

fun main() {

    val questionAndAnswerList = listOf(
        intArrayOf() to intArrayOf(),
        intArrayOf(
            1, 2, 3, 4,
        ) to intArrayOf(
            24, 12, 8, 6,
        ),
        intArrayOf(
            1, 1, 1, 1, 1,
        ) to intArrayOf(
            1, 1, 1, 1, 1,
        ),
        intArrayOf(
            1, 1, 0, 1, 1,
        ) to intArrayOf(
            0, 0, 1, 0, 0,
        ),
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            statisticalResult(
                arrayA = question
            ).contentEquals(other = answer)
        }
    )

}