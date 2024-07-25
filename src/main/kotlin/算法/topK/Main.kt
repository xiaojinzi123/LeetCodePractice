package 算法.topK

import org.junit.Assert
import 算法.support.ArrayHeap

private fun findTopK(list: List<Int>, k: Int): List<Int> {
    val heap = ArrayHeap<Int>()
    list.forEach {
        if (heap.size < k) {
            heap.add(it)
        } else {
            if (it > heap.peek()!!) {
                heap.pop()
                heap.add(it)
            }
        }
    }
    return heap.toList()
}

fun main() {

    val topK = 10

    // 生成 1000 个 0-1000 的随机数
    val list1 = List(1000) {
        (0..1000).random()
    }
    val list2 = List(1000) {
        (0..1000).random()
    }

    val questionAndAnswerList = listOf(
        list1 to list1.sortedDescending().take(n = topK),
        list2 to list2.sortedDescending().take(n = topK),
    )

    val result = questionAndAnswerList.all { (question, answer) ->
        findTopK(question, topK).sortedDescending() == answer
    }

    Assert.assertTrue(result)

}