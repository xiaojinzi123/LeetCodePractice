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

    fun iteratorForNext(): Iterator<Node<T>> {
        return object : Iterator<Node<T>> {
            var tempNode: Node<T>? = this@Node
            override fun hasNext(): Boolean {
                return tempNode != null
            }

            override fun next(): Node<T> {
                val result = tempNode
                tempNode = tempNode?.nextNode
                return result!!
            }
        }
    }

    fun toListForNext(): List<Node<T>> {
        return iteratorForNext().asSequence().toList()
    }

    fun sizeForNext(): Int {
        var count = 0
        var tempNode = this
        while (tempNode.nextNode != null) {
            count++
            tempNode = tempNode.nextNode!!
        }
        return count
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