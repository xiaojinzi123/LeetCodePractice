package 算法.打家劫舍

import org.junit.Assert
import kotlin.math.max

/**
 * dp[n] 表示我偷 N 家的最大金额
 * dp[n][0] 表示我偷第 N 家的最大金额
 * dp[n][1] 表示我不偷第 N 家的最大金额
 * dp[n][0] = dp[n - 1][1] + nums[n]
 * dp[n][1] = max(dp[n - 1][0], dp[n - 1][1])
 */
private fun rob(nums: IntArray): Int {
    val dp = Array(nums.size) {
        // [0] 表示偷的话, 最大金额
        // [1] 表示不偷的话, 最大金额
        IntArray(2) {
            0
        }
    }
    dp[0][0] = nums[0]
    dp[0][1] = 0
    for (index in (1..dp.lastIndex)) {
        dp[index][0] = dp[index - 1][1] + nums[index]
        dp[index][1] = max(dp[index - 1][0], dp[index - 1][1])
    }
    return max(
        dp[nums.lastIndex][0],
        dp[nums.lastIndex][1]
    )
}

fun main() {

    val questionAndAnswerList = listOf(
        intArrayOf(1, 2, 3, 1) to 4,
        intArrayOf(2, 7, 9, 3, 1) to 12,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            rob(question) == answer
        }
    )

}