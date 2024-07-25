package 算法.数组中重复的数字

import org.junit.Assert

fun main() {

    val list1 = listOf(1, 4, 7, 1, 12, 35)
    val list2 = listOf(4, 7, 1, 12, 35, 12)
    val list3 = listOf(4, 7, 1)
    Assert.assertTrue(find(list1) == 1)
    Assert.assertTrue(find(list2) == 12)
    Assert.assertThrows(IllegalArgumentException::class.java) {
        find(list3)
    }
    println("测试通过")

}

private fun find(list: List<Int>): Int {
    val map = mutableMapOf<Int, Unit>()
    list.forEach {
        if (map.containsKey(it)) {
            return it
        }
        map[it] = Unit
    }
    throw IllegalArgumentException("list 中没有重复的")
}