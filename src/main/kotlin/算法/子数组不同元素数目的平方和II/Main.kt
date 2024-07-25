package 算法.子数组不同元素数目的平方和II

/**
 * i <= j
 * dp[i][j] 表示数组 nums 从 i-j 所有子数组的 不同计数 的 平方 和
 *  1   0   0   0
 *  0   1   0   0
 *  0   0   1   0
 *  0   0   0   1
 *  没解出来
 */
private fun sumCounts(nums: IntArray): Int {
    if (nums.isEmpty()) {
        return 0
    }
    val dp = Array(nums.size) {
        IntArray(nums.size) {
            0
        }
    }
    for(index in 0..nums.lastIndex) {
        dp[index][index] = 1
    }
    return dp[0][nums.lastIndex]
}

fun main() {

}