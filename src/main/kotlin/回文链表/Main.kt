package 回文链表

import org.junit.Assert
import support.LinkNode
import support.toLinkedList

private fun reversalLink(head: LinkNode<Int>): LinkNode<Int> {
    var parentNode: LinkNode<Int>? = null
    var currentNode: LinkNode<Int>? = head
    while (currentNode != null) {
        val tempNode = currentNode.nextNode
        currentNode.nextNode = parentNode
        parentNode = currentNode
        currentNode = tempNode
    }
    return parentNode!!
}

/**
 * 是否是回文链表
 */
private fun isPalindrome(head: LinkNode<Int>): Boolean {
    var slowNode: LinkNode<Int>? = head
    var quickNode: LinkNode<Int>? = head
    var size = 1
    while (quickNode != null) {
        quickNode = quickNode.nextNode
        if (quickNode != null) {
            size += 1
        }
        quickNode = quickNode?.nextNode
        if (quickNode != null) {
            slowNode = slowNode?.nextNode
            size += 1
        }
    }

    if(size == 1) {
        return true
    }

    // 对部分链表进行反转
    var part2Link = slowNode!!.nextNode!!
    part2Link = reversalLink(head = part2Link)

    val compareCount = size / 2

    var result = true
    var tempNode1: LinkNode<Int>? = head
    var tempNode2: LinkNode<Int>? = part2Link
    for(index in 0 until compareCount) {
        if(tempNode1!!.value != tempNode2!!.value) {
            result = false
            break
        }
        tempNode1 = tempNode1.nextNode
        tempNode2 = tempNode2.nextNode
    }

    slowNode.nextNode = reversalLink(head = part2Link)

    return result
}

fun main() {

    val link1 = listOf(1, 2, 2, 1).toLinkedList()
    val link2 = listOf(1, 2, 3, 2, 1).toLinkedList()
    val link3 = listOf(1, 2, 3, 3, 2, 1).toLinkedList()
    val link4 = listOf(1, 2, 3, 3, 4, 2, 1).toLinkedList()
    val link5 = listOf(1).toLinkedList()

    Assert.assertTrue(
        listOf(
            link1 to true,
            link2 to true,
            link3 to true,
            link4 to false,
            link5 to true,
        ).all { (question, answer) ->
            isPalindrome(
                head = question,
            ) == answer
        }
    )

}