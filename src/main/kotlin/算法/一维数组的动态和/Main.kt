package 算法.一维数组的动态和

import org.junit.Assert

/**
 * dp[i] = dp[i - 1] + nums[i]
 * dp[0] = nums[0]
 */
private fun runningSum(nums: IntArray): IntArray {
    val dp = IntArray(nums.size)
    if (nums.isEmpty()) {
        return dp
    }
    dp[0] = nums[0]
    for (index in 1 until nums.size) {
        dp[index] = dp[index - 1] + nums[index]
    }
    return dp
}

fun main() {

    val questionAndAnswerList = listOf(
        intArrayOf() to intArrayOf(),
        intArrayOf(
            1, 2, 3, 4,
        ) to intArrayOf(
            1, 3, 6, 10,
        ),
        intArrayOf(
            1, 1, 1, 1, 1,
        ) to intArrayOf(
            1, 2, 3, 4, 5,
        ),
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            runningSum(
                nums = question,
            ).contentEquals((answer))
        }
    )

}