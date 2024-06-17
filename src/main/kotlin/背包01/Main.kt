package 背包01

import org.junit.Assert
import kotlin.math.max

private data class Item(
    // 重量
    val weight: Int,
    // 价值
    val value: Int,
)

/**
 * 每个物品只能最多用一次
 * dp[i][j] 表示前 i 个物品，背包容量为 j 时的最大价值
 * dp[i][j] = max(dp[i - 1][j], dp[i - 1][j - items[i].weight] + items[i].value)
 */
private fun maxValue(
    items: List<Item>,
    packageWeight: Int,
): Int {
    val dp = Array(items.size) {
        IntArray(packageWeight + 1) {
            -1
        }
    }
    // 初始化, 如果背包容量为 0, 那么最大价值为 0
    for (index in (0..dp.lastIndex)) {
        dp[index][0] = 0
    }
    // 初始化物品下标为 0 的, 如果背包容量小于物品的重量, 那么最大价值为 0, 否则就是物品的价值
    for (index in (1..dp[0].lastIndex)) {
        dp[0][index] = if (items[0].weight > index) {
            0
        } else {
            items[0].value
        }
    }

    for (itemIndex in (1..dp.lastIndex)) {
        for (weight in (1..dp[itemIndex].lastIndex)) {
            dp[itemIndex][weight] = max(
                dp[itemIndex - 1][weight],
                if (weight < items[itemIndex].weight) {
                    0
                } else {
                    dp[itemIndex - 1][weight - items[itemIndex].weight] + items[itemIndex].value
                }
            )
        }
    }

    return dp[items.lastIndex][packageWeight]

}

fun main() {

    val itemList1 = listOf(
        Item(1, 15),
        Item(3, 20),
        Item(4, 30),
    )

    val itemList2 = listOf(
        Item(1, 15),
        Item(4, 30),
        Item(3, 20),
    )

    val questionAndAnswerList = listOf(
        (itemList1 to 4) to 35,
        (itemList2 to 4) to 35,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            val (items, packageWeight) = question
            maxValue(
                items = items,
                packageWeight = packageWeight,
            ) == answer
        }
    )

}