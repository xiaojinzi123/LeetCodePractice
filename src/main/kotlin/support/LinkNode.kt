package support

import java.lang.IllegalArgumentException

class LinkNode<T>(
    val value: T,
    var preNode: LinkNode<T>? = null,
    var nextNode: LinkNode<T>? = null
) {

    fun createNext(value: T): LinkNode<T> {
        return LinkNode<T>(value = value, preNode = this).also {
            nextNode = it
        }
    }

    fun iteratorForNext(): Iterator<LinkNode<T>> {
        return object : Iterator<LinkNode<T>> {
            var tempNode: LinkNode<T>? = this@LinkNode
            override fun hasNext(): Boolean {
                return tempNode != null
            }

            override fun next(): LinkNode<T> {
                val result = tempNode
                tempNode = tempNode?.nextNode
                return result!!
            }
        }
    }

    fun toListForNext(): List<LinkNode<T>> {
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

/**
 * 列表转化为链表
 */
fun <T> List<T>.toLinkedList(): LinkNode<T> {
    if (this.isEmpty()) {
        throw IllegalArgumentException("集合不能为空")
    }
    val firstNode = LinkNode(value = this[0])
    var tempNode = firstNode
    for (index in 1 until this.size) {
        tempNode = tempNode.createNext(value = this[index]).also {
            it.preNode = tempNode
        }
    }
    return firstNode
}