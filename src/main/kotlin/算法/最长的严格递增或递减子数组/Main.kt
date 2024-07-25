package 算法.最长的严格递增或递减子数组

import org.junit.Assert
import kotlin.math.max

private fun longestMonotonicSubarray(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    if (nums.size == 1) {
        return 1
    }
    var result1 = 1
    var result2 = 1
    var resultIndex1 = 0
    var resultIndex2 = 0
    for (index in 1..nums.lastIndex) {
        if (nums[index] > nums[index - 1]) {
            result1 = max(result1, index - resultIndex1 + 1)
        } else {
            resultIndex1 = index
        }
        if (nums[index] < nums[index - 1]) {
            result2 = max(result2, index - resultIndex2 + 1)
        } else {
            resultIndex2 = index
        }
    }
    return max(result1, result2)
}

fun main() {

    val questionAndAnswerList = listOf(
        intArrayOf(
            1, 4, 3, 3, 2
        ) to 2,
        intArrayOf(
            3, 3, 3, 3
        ) to 1,
        intArrayOf(
            3, 2, 1
        ) to 3,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            longestMonotonicSubarray(
                nums = question
            ) == answer
        }
    )

}