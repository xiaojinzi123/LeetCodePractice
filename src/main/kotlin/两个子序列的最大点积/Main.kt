package 两个子序列的最大点积

import kotlin.math.max

/**
 * dp[i][j] 表示两个数字, 下标为0-i 和 0-j 的最大点积
 */
private fun maxDotProduct(nums1: IntArray, nums2: IntArray): Int {
    if (nums1.isEmpty() || nums2.isEmpty()) {
        return 0
    }
    val dp = Array(nums1.size) {
        IntArray(nums2.size) {
            0
        }
    }
    dp[0][0] = nums1[0] * nums2[0]
    for (index in (1..nums2.lastIndex)) {
        dp[0][index] = max(
            dp[0][index - 1], nums1[0] * nums2[index]
        )
    }
    for (index in (1..nums1.lastIndex)) {
        dp[index][0] = max(
            dp[index - 1][0], nums1[index] * nums2[0]
        )
    }
    for (i in 1..nums1.lastIndex) {
        for (j in 1..nums2.lastIndex) {
            dp[i][j] = maxOf(
                maxOf(
                    dp[i - 1][j - 1] + nums1[i] * nums2[j],
                    nums1[i] * nums2[j],
                ),
                maxOf(
                    dp[i][j - 1],
                    dp[i - 1][j],
                )
            )
        }
    }
    return dp[nums1.lastIndex][nums2.lastIndex]
}

fun main() {

    maxDotProduct(
        intArrayOf(
            2, 1, -2, 5
        ),
        intArrayOf(
            3, 0, -6
        ),
    )

}