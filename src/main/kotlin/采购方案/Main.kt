package 采购方案

/**
 * 暴力破解
 */
private fun purchasePlans1(nums: IntArray, target: Int): Int {
    var result = 0
    for (i in 0..<nums.lastIndex) {
        for (j in i + 1..nums.lastIndex) {
            if (nums[i] + nums[j] <= target) {
                result++
            }
        }
    }
    return result
}

/**
 * 双指针
 */
private fun purchasePlans2(nums: IntArray, target: Int): Int {
    nums.sort()
    var result = 0
    var i = 0
    var j = nums.lastIndex
    while (i < j + 1) {
        if (nums[i] + nums[j] <= target) {
            result += j - i
            i++
        } else {
            j--
        }
    }
    return result
}

fun main() {
    // 通过了, 比较简单
}