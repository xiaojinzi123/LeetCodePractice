package 算法.重建二叉树

import org.junit.Assert
import 算法.support.BinaryTreeNode

fun main() {

    // 前序遍历的结果
    val preOrder = listOf(3, 9, 20, 15, 7)
    // 中序遍历的结果
    val inOrder = listOf(9, 3, 15, 20, 7)

    val treeNode = rebuildTree(preOrder = preOrder, inOrder = inOrder)

    // 比较结果
    Assert.assertTrue(preOrder == treeNode.toPreOrderList())
    println(treeNode.toInOrderList())
    Assert.assertTrue(inOrder == treeNode.toInOrderList())

    println("测试通过")

}

private fun rebuildTree(
    preOrder: List<Int>, preOrderRange: IntRange = preOrder.indices,
    inOrder: List<Int>, inOrderRange: IntRange = inOrder.indices,
): BinaryTreeNode<Int> {
    if (preOrderRange.first == preOrderRange.last) {
        return BinaryTreeNode(value = preOrder[preOrderRange.first])
    }
    // 根节点的值
    val rootValue = preOrder[preOrderRange.first]
    var rootIndexInInOrderList = -1
    // 在中序遍历中找到值的位置
    for (index in inOrderRange) {
        if (inOrder[index] == rootValue) {
            rootIndexInInOrderList = index
        }
    }
    if (rootIndexInInOrderList == -1) {
        throw IllegalArgumentException("rootIndexInInOrderList = -1")
    }
    val rootNode = BinaryTreeNode(value = rootValue)
    // 左右子树的个数
    val leftTreeCount = rootIndexInInOrderList - inOrderRange.first
    val rightTreeCount = inOrderRange.last - rootIndexInInOrderList

    rootNode.left = rebuildTree(
        preOrder = preOrder,
        preOrderRange = IntRange(
            start = preOrderRange.first + 1,
            endInclusive = preOrderRange.first + leftTreeCount,
        ),
        inOrder = inOrder,
        inOrderRange = IntRange(
            start = rootIndexInInOrderList - leftTreeCount,
            endInclusive = leftTreeCount - 1,
        ),
    )

    rootNode.right = rebuildTree(
        preOrder = preOrder,
        preOrderRange = IntRange(
            start = preOrderRange.first + leftTreeCount + 1,
            endInclusive = preOrderRange.first + leftTreeCount + rightTreeCount,
        ),
        inOrder = inOrder,
        inOrderRange = IntRange(
            start = rootIndexInInOrderList + 1,
            endInclusive = rootIndexInInOrderList + rightTreeCount,
        ),
    )

    return rootNode
}

