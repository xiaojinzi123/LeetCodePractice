package 数组中的第K个最大元素

import org.junit.Assert
import support.ArrayHeap

private fun findKthLargest(nums: IntArray, k: Int): Int {
    if (nums.isEmpty()) {
        throw IllegalArgumentException("nums is empty")
    }
    val heap = ArrayHeap<Int>()
    for ((index, value) in nums.withIndex()) {
        if (heap.size < k) {
            heap.add(value = value)
        } else {
            if (value > heap.peek()!!) {
                heap.pop()
                heap.add(value = value)
            }
        }
    }
    return heap.peek()!!
}

fun main() {

    val questionAndAnswerList = listOf(
        (listOf(3,2,1,5,6,4) to 2) to 5,
        (listOf(3,2,3,1,2,4,5,5,6) to 4) to 4,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            findKthLargest(nums = question.first.toIntArray(), k = question.second) == answer
        }
    )

}