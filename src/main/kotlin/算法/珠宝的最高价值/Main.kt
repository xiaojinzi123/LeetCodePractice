package 算法.珠宝的最高价值

import org.junit.Assert
import kotlin.math.max

/**
 * frame 是二维数组
 * dp[i][j] = max(dp[i-1][j], dp[i][j-1]) + frame[i][j]
 */
private fun jewelleryValue(frame: Array<IntArray>): Int {
    if (frame.isEmpty() || frame[0].isEmpty()) {
        return 0
    }
    val dp = Array(frame.size) {
        IntArray(frame[0].size) {
            0
        }
    }
    dp[0][0] = frame[0][0]
    for (index in 1..dp[0].lastIndex) {
        dp[0][index] = dp[0][index - 1] + frame[0][index]
    }
    for (index in 1..dp.lastIndex) {
        dp[index][0] = dp[index - 1][0] + frame[index][0]
    }
    for (i in 1..dp.lastIndex) {
        for (j in 1..dp[i].lastIndex) {
            dp[i][j] = max(
                a = dp[i - 1][j],
                b = dp[i][j - 1],
            ) + frame[i][j]
        }
    }
    return dp[dp.lastIndex][dp[0].lastIndex]
}

fun main() {

    val questionAndAnswerList = listOf(
        arrayOf(
            intArrayOf(
                1, 3, 1
            ),
            intArrayOf(
                1, 5, 1
            ),
            intArrayOf(
                4, 2, 1
            ),
        ) to 12,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            jewelleryValue(
                question
            ) == answer
        }
    )

}