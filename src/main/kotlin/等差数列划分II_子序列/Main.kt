package 等差数列划分II_子序列

import org.junit.Assert

/**
 * 这个贼难理解, 我没写出来
 */
private fun numberOfArithmeticSlices1(nums: IntArray): Int {
    // 状态方程为：
    // f[i][d] 表示以 nums[i] 结尾，公差为 d 的弱等差子序列的个数
    // f[i][d] = f[j][d] + 1 (0 <= j < i)
    // f[j][d] 表示f[i][d]的前一个状态, 仅仅是前一个哦
    // 定义二维数组
    val n = nums.size
    val f = Array(n) { HashMap<Int, Int>() }
    var ans = 0
    for (i in 0 until n) {
        for (j in 0 until i) {
            val d = nums[i] - nums[j]
            val cnt = f[j].getOrDefault(d, 0)
            ans += cnt
            f[i][d] = f[i].getOrDefault(d, 0) + cnt + 1
        }
    }
    return ans
}

fun main() {

    val questionAndAnswerList = listOf(
        listOf(2, 4, 6, 8, 10) to 7,
        listOf(7, 7, 7, 7, 7) to 16,
    )

    val result1 = questionAndAnswerList.all { (question, answer) ->
        numberOfArithmeticSlices1(
            nums = question.toIntArray()
        ) == answer
    }

    Assert.assertTrue(result1)

}