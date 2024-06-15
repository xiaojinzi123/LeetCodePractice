package N叉树的后序遍历

import org.junit.Assert
import support.TreeNode

private fun postOrder(root: TreeNode<Int>): List<Int> {
    return root.toPostOrderList()
}

fun main() {

    val questionAndAnswerList = listOf(
        TreeNode(
            value = 1, children = listOf(
                TreeNode(
                    value = 3, children = listOf(
                        TreeNode(value = 5),
                        TreeNode(value = 6),
                    )
                ),
                TreeNode(value = 2),
                TreeNode(value = 4),
            )
        ) to listOf(5, 6, 3, 2, 4, 1),
        TreeNode(
            value = 1, children = listOf(
                TreeNode(value = 2),
                TreeNode(
                    value = 3, children = listOf(
                        TreeNode(value = 6),
                        TreeNode(
                            value = 7, children = listOf(
                                TreeNode(
                                    value = 11, children = listOf(
                                        TreeNode(value = 14),
                                    )
                                ),
                            )
                        ),
                    )
                ),
                TreeNode(
                    value = 4, children = listOf(
                        TreeNode(
                            value = 8, children = listOf(
                                TreeNode(value = 12),
                            )
                        ),
                    )
                ),
                TreeNode(
                    value = 5, children = listOf(
                        TreeNode(
                            value = 9, children = listOf(
                                TreeNode(value = 13),
                            )
                        ),
                        TreeNode(value = 10),
                    )
                ),
            )
        ) to listOf(2, 6, 14, 11, 7, 3, 12, 8, 4, 13, 9, 10, 5, 1)
    )

    val result = questionAndAnswerList.all { (question, answer) ->
        postOrder(question) == answer
    }

    Assert.assertTrue(result)

}