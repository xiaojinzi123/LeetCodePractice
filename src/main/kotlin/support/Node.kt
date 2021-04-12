package support

import java.lang.IllegalArgumentException

class Node<T>(
    val value: T,
    var preNode: Node<T>? = null,
    var nextNode: Node<T>? = null
) {
    fun createNext(value: T): Node<T> {
        return Node<T>(value = value, preNode = this).also {
            nextNode = it
        }
    }
}

fun <T> List<T>.toLinkedList(): Node<T> {
    if (this.isEmpty()) {
        throw IllegalArgumentException("集合不能为空")
    }
    val firstNode = Node(value = this[0])
    var tempNode = firstNode
    for (index in 1 until this.size) {
        tempNode = tempNode.createNext(value = this[index]).also {
            it.preNode = tempNode
        }
    }
    return firstNode
}