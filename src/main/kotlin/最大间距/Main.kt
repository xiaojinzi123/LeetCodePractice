package 最大间距

import java.util.*

fun maximumGap(nums: IntArray): Int {
    if (nums.size < 2) return 0
    Arrays.sort(nums)
    var result = 0
    for (index in (1 until nums.size)) {
        val tempValue = nums[index] - nums[index - 1]
        if (tempValue > result) {
            result = tempValue
        }
    }
    return result
}

/**
 * https://leetcode.cn/problems/maximum-gap/
 */
fun main() {


}