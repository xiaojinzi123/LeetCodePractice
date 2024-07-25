package 算法.相交链表

import org.junit.Assert
import 算法.support.LinkNode
import 算法.support.toLinkedList
import java.util.*
import kotlin.math.absoluteValue

/**
 * https://leetcode.cn/problems/intersection-of-two-linked-lists/description/
 */
fun main() {

    """
        算法结果返回第一个相交的值
        下面算法比较的是 int 的值的大小, 其实应该比较的是地址. 这样才能证明是同一个节点了
        但是那样子写的比较复杂, 就用 Int 简单代替下
    """.trimIndent()

    val link1_1 = listOf(1, 2, 3, 11, 12, 13).toLinkedList()
    val link1_2 = listOf(4, 5, 6, 11, 12, 13).toLinkedList()

    val link2_1 = listOf(1, 10, 12, 13).toLinkedList()
    val link2_2 = listOf(4, 5, 6, 10, 12, 13).toLinkedList()

    Assert.assertTrue(method1(link1_1, link1_2) == 11)
    Assert.assertTrue(method1(link2_1, link2_2) == 10)

    Assert.assertTrue(method2(link1_1, link1_2) == 11)
    Assert.assertTrue(method2(link2_1, link2_2) == 10)

}

/**
 * 分别放入一个栈中
 */
private fun method1(
    link1: LinkNode<Int>,
    link2: LinkNode<Int>,
): Int? {
    if (link1.nextNode == null || link2.nextNode == null) {
        return null
    }
    val stack1 = Stack<Int>().apply {
        link1.iteratorForNext().forEach { item ->
            this.add(item.value)
        }
    }
    val stack2 = Stack<Int>().apply {
        link2.iteratorForNext().forEach { item ->
            this.add(item.value)
        }
    }
    val loopCount = minOf(a = stack1.size, stack2.size)
    var result: Int? = null
    for (index in loopCount.downTo(1)) {
        val tempValue1 = stack1.pop()
        val tempValue2 = stack2.pop()
        if (tempValue1 != tempValue2) {
            break
        }
        result = tempValue1
    }
    return result
}

/**
 * 分别放入一个栈中
 */
private fun method2(
    link1: LinkNode<Int>,
    link2: LinkNode<Int>,
): Int? {
    if (link1.nextNode == null || link2.nextNode == null) {
        return null
    }
    val size1 = link1.sizeForNext()
    val size2 = link2.sizeForNext()

    val diffSize = (size1 - size2).absoluteValue

    // 对超出的长度先删除
    val (resultLink1, resultLink2) = if (size1 > size2) {
        var tempLink = link1
        repeat(times = diffSize) {
            tempLink = tempLink.nextNode!!
        }
        tempLink to link2
    } else if (size2 > size1) {
        var tempLink = link2
        repeat(times = diffSize) {
            tempLink = tempLink.nextNode!!
        }
        link1 to tempLink
    } else {
        link1 to link2
    }

    var tempNode1: LinkNode<Int>? = resultLink1
    var tempNode2: LinkNode<Int>? = resultLink2

    while (tempNode1 != null && tempNode2 != null) {
        if(tempNode1.value == tempNode2.value) {
            return tempNode1.value
        }
        tempNode1 = tempNode1.nextNode
        tempNode2 = tempNode2.nextNode
    }

    return null

}