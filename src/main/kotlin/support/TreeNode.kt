package support

/**
 * 二叉树节点
 */
class TreeNode<T>(
    var value: T,
    var left: TreeNode<T>? = null,
    var right: TreeNode<T>? = null,
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

    private fun preOrderLoop(treeNode: TreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            list.add(it.value)
            preOrderLoop(it.left, list)
            preOrderLoop(it.right, list)
        }
    }

    private fun inOrderLoop(treeNode: TreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            inOrderLoop(it.left, list)
            list.add(it.value)
            inOrderLoop(it.right, list)
        }
    }

}