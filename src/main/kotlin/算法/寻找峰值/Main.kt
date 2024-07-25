package 算法.寻找峰值

import org.junit.Assert

/**
 * https://leetcode.cn/problems/find-peak-element/
 */
fun main() {

    """
        方法返回下标, 也就是峰值的下标
    """.trimIndent()

    val list1 = listOf(1, 2, 3, 1)

    val list2 = listOf(1, 2, 1, 3, 5, 6, 4)

    Assert.assertTrue(method1(list1.toIntArray()) == listOf(2))
    Assert.assertTrue(method1(list2.toIntArray()) == listOf(1, 5))

}

private fun method1(nums: IntArray): List<Int> {
    val resultList = mutableListOf<Int>()
    for (i in nums.indices) {
        if (i == 0) {
            if (nums.size == 1) {
                resultList.add(i)
            } else if (nums[0] > nums[1]) {
                resultList.add(i)
            }
        } else if (i == nums.size - 1) {
            if (nums[i] > nums[i - 1]) {
                resultList.add(i)
            }
        } else {
            if (nums[i] > nums[i - 1] && nums[i] > nums[i + 1]) {
                resultList.add(i)
            }
        }
    }
    return resultList
}