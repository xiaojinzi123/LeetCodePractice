package 两数相加

import org.junit.Assert
import support.Node
import support.toLinkedList

/**
 * https://leetcode-cn.com/problems/add-two-numbers/
 */
fun main() {

    val num1_1 = listOf(2, 4, 3).toLinkedList()
    val num1_2 = listOf(5, 6, 4).toLinkedList()

    val num2_1 = listOf(2, 4, 5).toLinkedList()
    val num2_2 = listOf(5, 6, 4).toLinkedList()

    Assert.assertTrue(add(num1_1, num1_2) == 807)
    Assert.assertTrue(add(num2_1, num2_2) == 1007)

}

private fun add(node1: Node<Int>, node2: Node<Int>): Int {
    val resultSb = StringBuffer()
    var tempNode1: Node<Int>? = node1
    var tempNode2: Node<Int>? = node2
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
    if (isCarry) {
        resultSb.append(1)
    }
    return resultSb.reverse().toString().toInt()
}