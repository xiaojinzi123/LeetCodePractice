package 算法.support

/**
 * 二叉树节点
 */
class TreeNode<T>(
    var value: T,
    var children: List<TreeNode<T>> = emptyList(),
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
     * 后序遍历的输出
     */
    fun toPostOrderList(): List<T> {
        val list = mutableListOf<T>()
        postOrderLoop(this, list)
        return list
    }

    private fun preOrderLoop(treeNode: TreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            list.add(it.value)
            treeNode.children.forEach { item ->
                preOrderLoop(treeNode = item, list = list)
            }
        }
    }

    private fun postOrderLoop(treeNode: TreeNode<T>?, list: MutableList<T>) {
        treeNode?.let {
            treeNode.children.forEach { item ->
                postOrderLoop(treeNode = item, list = list)
            }
            list.add(it.value)
        }
    }

}