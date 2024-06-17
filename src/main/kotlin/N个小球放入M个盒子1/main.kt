package N个小球放入M个盒子1

/**
 * N 个球放入 M 个盒子中有多少种可能
 * 每个盒子至少有一个小球. 并且放好后如果按照把盒子按照小球个数排序之后重复的, 只能算一个
 * 比如 5 个小球放入 3 个盒子, 113, 311, 131 都算同一个可能
 * 3 个球 2个盒子, 4 中插板方式, 2 中排列结果
 * |***
 * *|**
 * **|*
 * ***|
 * 3 个球 3个盒子
 * 003
 * 030
 * 300
 * 012
 * 021
 * 102
 * 120
 * 201
 * 210
 * 111
 */
private fun cal(n: Int, m: Int): Int {
    if (n < m) {
        throw IllegalArgumentException("n must be greater than m")
    }
    if (n == m) {
        return 1
    }
    if (m == 1) {
        return 1
    }
    // 插板法, 板的个数
    val count = m - 1
    // 在 n + 1 个位置插入两个板
    return -1
}

fun main() {
    println(cal(5, 3))
}