package 反转链表

import org.junit.Assert
import support.Node
import support.toLinkedList

private fun <T> reverseList1(head: Node<T>): Node<T> {
    // 创建反转后的 Head, 首先是为原始的 Head
    var resultHead = Node(
        value = head.value,
    )
    var tempNode: Node<T>? = head.nextNode
    while (tempNode != null) {
        resultHead = Node(
            value = tempNode.value,
            nextNode = resultHead,
        )
        tempNode = tempNode.nextNode
    }
    return resultHead
}

fun main() {

    val questionAndAnswerList = listOf(
        listOf(1, 2, 3, 4, 5) to listOf(5, 4, 3, 2, 1),
        listOf(1, 2) to listOf(2, 1),
    )

    Assert.assertTrue(
        questionAndAnswerList.all { item ->
            reverseList1(item.first.toLinkedList()).toListForNext().map { it.value } == item.second
        }
    )

}