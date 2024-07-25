package 算法.两数之和IV输入二叉搜索树

import org.junit.Assert
import 算法.support.BinaryTreeNode
import 算法.support.toBinaryTreeNode

private fun findTarget(root: BinaryTreeNode<Int>?, k: Int, hashSet: HashSet<Int>): Boolean {
    if (root == null) {
        return false
    }
    if (hashSet.contains(
            k - root.value
        )
    ) {
        return true
    }
    hashSet.add(root.value)
    return findTarget(
        root = root.left, k = k, hashSet = hashSet,
    ) || findTarget(
        root = root.right, k = k, hashSet = hashSet,
    )
}

fun main() {

    val questionAndAnswerList = listOf(
        Triple(
            first = listOf(
                5, 3, 6, 2, 4, null, 7
            ).toBinaryTreeNode(),
            second = 9,
            third = true,
        ),
        Triple(
            first = listOf(
                5, 3, 6, 2, 4, null, 7
            ).toBinaryTreeNode(),
            second = 28,
            third = false,
        ),
    )

    val result = questionAndAnswerList.all { (question, k, answer) ->
        findTarget(
            root = question, k = k, hashSet = hashSetOf(),
        ) == answer
    }

    Assert.assertTrue(result)

}