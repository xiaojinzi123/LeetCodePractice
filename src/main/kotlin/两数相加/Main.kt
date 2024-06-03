package 两数相加

import org.junit.Assert
import support.Node
import support.toLinkedList

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
fun main() {

    """
        由于链表的头是数字的个位数
        也就是 个位 --> 十位 --> 百位
        思路：从左边循环到右边, 遇到要进位就标记一下, 下一次循环的时候加上进位
        最后循环结束, 如果需要进位, 那就在最后加上一个 1
    """.trimIndent()

    val num1_1 = listOf(2, 4, 3).toLinkedList()
    val num1_2 = listOf(5, 6, 4).toLinkedList()

    val num2_1 = listOf(2, 4, 5).toLinkedList()
    val num2_2 = listOf(5, 6, 4).toLinkedList()

    val num3_1 = listOf(1, 1, 1).toLinkedList()
    val num3_2 = listOf(2, 2, 2, 2).toLinkedList()

    Assert.assertTrue(add(num1_1, num1_2) == 807)
    Assert.assertTrue(add(num2_1, num2_2) == 1007)
    Assert.assertTrue(add(num3_1, num3_2) == 2333)

}

private fun add(node1: Node<Int>, node2: Node<Int>): Int {
    val resultSb = StringBuffer()
    var tempNode1: Node<Int>? = node1
    var tempNode2: Node<Int>? = node2
    // 是否进位
    var isCarry = false
    while (tempNode1 != null || tempNode2 != null) {
        var sum = (tempNode1?.value ?: 0) + (tempNode2?.value ?: 0)
        if (isCarry) {
            sum++
        }
        isCarry = false
        if (sum > 9) {
            isCarry = true
            sum %= 10
        }
        resultSb.append(sum)
        tempNode1 = tempNode1?.nextNode
        tempNode2 = tempNode2?.nextNode
    }
    // 如果结束了如果还需要进位, 那就 + 1
    if (isCarry) {
        resultSb.append(1)
    }
    return resultSb.reverse().toString().toInt()
}