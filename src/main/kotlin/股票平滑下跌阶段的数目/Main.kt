package 股票平滑下跌阶段的数目

import org.junit.Assert

/**
 * // dp[i][0] 表示第0-i个数组有连续的多少个
 * // dp[i][1] 表示数目
 * 如果和上一个是连续下降的
 * dp[i][0] = dp[i-1][0] + 1
 * 如果不是下降的 dp[i][0] = 1
 * 数目的这个一直都是下面这样的
 * dp[i][1] = dp[i-1][1] + dp[i][0]
 */
private fun getDescentPeriods(prices: IntArray): Long {
    if (prices.isEmpty()) {
        return 0
    }
    val dp = Array(prices.size) {
        LongArray(2) {
            0
        }
    }
    dp[0][0] = 1
    dp[0][1] = 1
    for (i in (1..dp.lastIndex)) {
        if(prices[i] + 1 == prices[i-1]) {
            dp[i][0] = dp[i - 1][0] + 1
        } else {
            dp[i][0] = 1
        }
        dp[i][1] = dp[i - 1][1] + dp[i][0]
    }
    return dp[dp.lastIndex][1]
}

fun main() {

    val questionAndAnswerList = listOf(
        intArrayOf(
            3, 2, 1, 4
        ) to 7,
        intArrayOf(
            8, 6, 7, 7
        ) to 4,
        intArrayOf(
            1
        ) to 1,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            getDescentPeriods(prices = question).toInt() == answer
        }
    )

}