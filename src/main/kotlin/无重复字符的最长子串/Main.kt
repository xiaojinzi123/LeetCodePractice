package 无重复字符的最长子串

import org.junit.Assert
import kotlin.math.max

/**
 * 不含重复字符的字符串
 */
private fun lengthOfLongestSubstring(str: String): String {
    if (str.isEmpty()) {
        return ""
    }
    // 声明数组并且赋值 -1
    val arr = IntArray(256) {
        -1
    }
    var resultStartIndex = 0
    var resultEndIndex = 0
    var startIndex = 0
    for (index in str.indices) {
        // char 对应的 acill 码
        val charIndex = str[index].code
        // 这里是最关键的一部分.
        // 如果当前字符在之前出现过, 那么就需要重新计算 startIndex
        // 第一种情况就是, 这个字符对应的 index 位置在 startIndex 之前, 那么 startIndex 不需要变化, 因为这个不算重复
        // 第二种情况就是, 这个字符对应的 index 位置在 startIndex 之后, 那么 startIndex 就需要变成这个字符对应的 index 位置 + 1
        if (arr[charIndex] != -1) {
            startIndex = max(startIndex, arr[charIndex] + 1)
        }
        if ((index - startIndex) > (resultEndIndex - resultStartIndex)) {
            resultStartIndex = startIndex
            resultEndIndex = index
        }
        // 存储当前字符的位置
        arr[charIndex] = index
    }
    return str.substring(resultStartIndex, resultEndIndex + 1)
}

fun main() {

    val str1 = "abcabcbb"
    val str2 = "bbbbb"
    val str3 = "pwwkew"
    val str4 = ""
    val str5 = "12345367891"
    val str6 = "123123456712"
    val str7 = "123123412"

    Assert.assertTrue("abc" == lengthOfLongestSubstring(str = str1))
    Assert.assertTrue("b" == lengthOfLongestSubstring(str = str2))
    Assert.assertTrue("wke" == lengthOfLongestSubstring(str = str3))
    Assert.assertTrue("" == lengthOfLongestSubstring(str = str4))
    Assert.assertTrue("45367891" == lengthOfLongestSubstring(str = str5))
    Assert.assertTrue("1234567" == lengthOfLongestSubstring(str = str6))
    Assert.assertTrue("1234" == lengthOfLongestSubstring(str = str7))

}
