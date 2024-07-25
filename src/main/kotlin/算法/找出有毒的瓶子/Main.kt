package 算法.找出有毒的瓶子

import org.junit.Assert
import kotlin.random.Random

fun main() {

    // 瓶子的个数
    val bottleCount = 1000
    // 毒瓶子的序号, 从 1 开始的
    val poisonBottleIndex = Random.nextInt(
        from = 1, until = bottleCount + 1,
    )
    println("毒瓶子的序号是: $poisonBottleIndex")

    // 每一个瓶子的序号转换为二进制字符串, 二进制字符串是逆序的
    val arr = (1..1000).map { serialNumber ->
        serialNumber.toString(radix = 2).reversed() to (serialNumber == poisonBottleIndex)
    }

    val mouseCount = arr.last().first.length

    // 记录小老鼠是否死亡的数组
    val arr2 = BooleanArray(size = mouseCount) {
        false
    }

    for ((serialNumber, isPoisonBottle) in arr) {
        for ((index, c) in serialNumber.withIndex()) {
            if (c == '1') { // 如果需要吃, 吃到有毒的就得死
                arr2[index] = arr2[index] || isPoisonBottle
            }
        }
    }

    val poisonBottleResult =
        arr2.joinToString(separator = "") { if (it) "1" else "0" }.reversed().toInt(radix = 2).apply(::println)

    Assert.assertTrue(poisonBottleResult == poisonBottleIndex)

}