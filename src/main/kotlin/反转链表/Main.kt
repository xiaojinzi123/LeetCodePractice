package 反转链表

import org.junit.Assert
import support.LinkNode
import support.toLinkedList

// 这种是新创建了一个链表
private fun <T> reverseList1(head: LinkNode<T>): LinkNode<T> {
    // 创建反转后的 Head, 首先是为原始的 Head
    var resultHead = LinkNode(
        value = head.value,
    )
    var tempNode: LinkNode<T>? = head.nextNode
    while (tempNode != null) {
        resultHead = LinkNode(
            value = tempNode.value,
            nextNode = resultHead,
        )
        tempNode = tempNode.nextNode
    }
    return resultHead
}

// 不能用另外一个链表, 需要在原链表上进行操作
private fun <T> reverseList2(head: LinkNode<T>): LinkNode<T> {
    var parentNode: LinkNode<T>? = null
    var currentNode: LinkNode<T>? = head
    while (currentNode != null) {
        val tempNode = currentNode.nextNode
        currentNode.nextNode = parentNode
        parentNode = currentNode
        currentNode = tempNode
    }
    return parentNode!!
}

fun main() {

    val questionAndAnswerList = listOf(
        listOf(1, 2, 3, 4, 5) to listOf(5, 4, 3, 2, 1),
        listOf(1, 2) to listOf(2, 1),
    )

    Assert.assertTrue(
        questionAndAnswerList.all { item ->
            reverseList1(item.first.toLinkedList()).toListForNext().map { it.value } == item.second
        } && questionAndAnswerList.all { item ->
            reverseList2(item.first.toLinkedList()).toListForNext().map { it.value } == item.second
        }
    )

}