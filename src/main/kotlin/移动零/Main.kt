package 移动零

import org.junit.Assert
import support.swap

private fun moveZeroes(nums: IntArray): Unit {
    // 指向最左边为 0 的下标
    var index1 = 0
    // 指向从 index1 之后的第一个不为 0 的下标
    var index2 = 0
    while (index2 < nums.size) {
        while (index1 < nums.size && nums[index1] != 0) {
            index1++
        }
        index2 = index1 + 1
        while (index2 < nums.size && nums[index2] == 0) {
            index2++
        }
        if (index2 < nums.size) {
            nums.swap(
                index1 = index1,
                index2 = index2,
            )
            index1++
        }
    }
}

fun main() {
    val questionAndAnswerList = listOf(
        intArrayOf(
            1, 2, 0, 3, 4, 0, 5,
        ) to intArrayOf(
            1, 2, 3, 4, 5, 0, 0
        ),
        intArrayOf(
            0, 1, 0, 3, 12,
        ) to intArrayOf(
            1, 3, 12, 0, 0
        ),
        intArrayOf(
            0,
        ) to intArrayOf(
            0
        ),
    )
    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            moveZeroes(nums = question)
            question.contentEquals(answer)
        }
    )
}