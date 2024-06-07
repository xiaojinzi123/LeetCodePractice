package 回文数

import org.junit.Assert

// 转化为字符串
private fun isPalindrome1(x: Int): Boolean {
    val str = x.toString()
    var i = 0
    var j = str.lastIndex
    while (i < j) {
        if (str[i] != str[j]) {
            return false
        }
        i++
        j--
    }
    return true
}

// 不能转化为字符串来判断
// 思路就是把数字给反过来, 看看是否相等
private fun isPalindrome2(x: Int): Boolean {
    if (x < 0) {
        return false
    }
    var temp = x
    var reverse = 0
    while (temp != 0) {
        val pop = temp % 10
        temp /= 10
        reverse = reverse * 10 + pop
    }
    return x == reverse
}

fun main() {

    val num1 = 123321
    val num2 = 12321
    val num3 = 1234521

    val questionAndAnswers = listOf(
        num1 to true,
        num2 to true,
        num3 to false,
    )

    val b1 = questionAndAnswers.all { item ->
        isPalindrome1(item.first) == item.second
    }

    val b2 = questionAndAnswers.all { item ->
        isPalindrome2(item.first) == item.second
    }

    Assert.assertTrue(
        b1 && b2,
    )

}