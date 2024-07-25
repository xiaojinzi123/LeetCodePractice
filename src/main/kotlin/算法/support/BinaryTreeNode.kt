package 算法.support

import org.junit.Assert

/**
 * 二叉树节点
 */
class BinaryTreeNode<T>(
    var value: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
) // 占位
{

    /**
     * 前序遍历的输出
     */
    fun toPreOrderList(): List<T> {
        val list = mutableListOf<T>()
        preOrderLoop(this, list)
        return list
    }

    /**
     * 中序遍历的输出
     */
    fun toInOrderList(): List<T> {
        val list = mutableListOf<T>()
        inOrderLoop(this, list)
        return list
    }

    /**
     * 后序遍历的输出
     */
    fun toPostOrderList(): List<T> {
        val list = mutableListOf<T>()
        postOrderLoop(this, list)
        return list
    }

    private fun preOrderLoop(treeNode: BinaryTreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            list.add(it.value)
            preOrderLoop(it.left, list)
            preOrderLoop(it.right, list)
        }
    }

    private fun inOrderLoop(treeNode: BinaryTreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            inOrderLoop(it.left, list)
            list.add(it.value)
            inOrderLoop(it.right, list)
        }
    }

    private fun postOrderLoop(treeNode: BinaryTreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            postOrderLoop(it.left, list)
            postOrderLoop(it.right, list)
            list.add(it.value)
        }
    }

}

/**
 * 给定的 List 一定是从上往下一层层的数据，null 表示空节点
 */
fun <T> List<T?>.toBinaryTreeNode(): BinaryTreeNode<T> {
    this.firstOrNull() ?: throw IllegalArgumentException("List is empty")
    val nodeList: List<BinaryTreeNode<T>?> = this.map { item ->
        item?.let {
            BinaryTreeNode(item)
        }
    }
    nodeList.forEachIndexed { index, node ->
        if (index > 0) {
            // 对每一个节点的上下结构进行计算
            val parentIndex = (index - 1) / 2
            val parentNode = nodeList.get(index = parentIndex) ?: throw IllegalArgumentException("Parent node is null")
            if (index % 2 == 0) { // 右节点
                parentNode.right = node
            } else {
                parentNode.left = node
            }
        }
    }
    return nodeList.first() ?: throw IllegalArgumentException("Root node is null")
}

fun main() {

    val questionAndAnswerList = listOf(
        listOf(
            5, 3, 6, 2, 4, null, 7
        ) to listOf(
            5, 3, 2, 4, 6, 7
        ),
    )

    val result = questionAndAnswerList.all { (list1, list2) ->
        list1.toBinaryTreeNode().toPreOrderList() == list2
    }

    Assert.assertTrue(result)

}