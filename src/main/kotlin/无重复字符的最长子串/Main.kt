package 无重复字符的最长子串

import org.junit.Assert
import kotlin.math.max

fun main() {

    val str1 = "abcabcbb"
    val str2 = "bbbbb"
    val str3 = "pwwkew"
    val str4 = ""
    val str5 = "12345367891"

    Assert.assertTrue("abc" == find(str = str1))
    Assert.assertTrue("b" == find(str = str2))
    Assert.assertTrue("wke" == find(str = str3))
    Assert.assertTrue("" == find(str = str4))
    Assert.assertTrue("45367891" == find(str = str5))

}

/**
 * 不含重复字符的字符串
 */
private fun find(str: String): String {
    if (str.isEmpty()) {
        return ""
    }
    val arr = IntArray(256).apply {
        this.fill(-1)
    }
    var resultStartIndex = 0
    var resultEndIndex = 0
    var startIndex = 0
    var endIndex = -1
    for(index in str.indices) {
        // char 对应的 acill 码
        val charIndex = str[index].toInt()
        endIndex = index
        if(arr[charIndex] != -1) {
            startIndex = max(startIndex, arr[charIndex] + 1)
        }
        if((endIndex - startIndex) > (resultEndIndex - resultStartIndex)) {
            resultStartIndex = startIndex
            resultEndIndex = endIndex
        }
        arr[charIndex] = index
    }
    return str.substring(resultStartIndex, resultEndIndex + 1)
}