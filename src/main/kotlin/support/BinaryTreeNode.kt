package support

/**
 * 二叉树节点
 */
class BinaryTreeNode<T>(
    var value: T,
    var left: BinaryTreeNode<T>? = null,
    var right: BinaryTreeNode<T>? = null,
) {

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