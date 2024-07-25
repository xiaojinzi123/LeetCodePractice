package 算法.最长回文子串

/**
 * 暴力破解
 */
private fun longestPalindrome1(s: String): String {
    var result = ""
    // 回文数是奇数的时候
    for (index in (1..<s.lastIndex)) {
        var diffIndex = 1
        while (index - diffIndex >= 0 && index + diffIndex <= s.lastIndex) {
            if (s[index - diffIndex] == s[index + diffIndex]) {
                diffIndex++
            } else {
                break
            }
        }
        if (diffIndex > 1) {
            val tempResult = s.substring(
                startIndex = index - diffIndex + 1,
                endIndex = index + diffIndex,
            )
            if(tempResult.length > result.length) {
                result = tempResult
            }
        }
    }
    // 回文数是偶数的时候
    for (index in (0..<s.lastIndex)) {
        var diffIndex = 0
        while (index - diffIndex >= 0 && index + diffIndex + 1 <= s.lastIndex) {
            if (s[index - diffIndex] == s[index + diffIndex + 1]) {
                diffIndex++
            } else {
                break
            }
        }
        if (diffIndex > 0) {
            val tempResult = s.substring(
                startIndex = index - diffIndex + 1,
                endIndex = index + diffIndex + 1,
            )
            if(tempResult.length > result.length) {
                result = tempResult
            }
        }
    }
    return result
}

/**
 * 动态规划, 文件夹中有图示
 * 时间复杂度 O(n^2)
 */
private fun longestPalindrome2(s: String): String {
    var result: String = ""
    // 二维数组, f(x, y) 表示从 x 到 y 的字符串是否是回文数, x 一定小于等于 y
    val dp = Array(s.length) { BooleanArray(s.length) }
    for(x in (s.lastIndex downTo 0)) {
        for(y in (x..s.lastIndex)) {
            if (x == y) {
                dp[x][y] = true
            } else if (y - x == 1) {
                dp[x][y] = s[x] == s[y]
            } else {
                dp[x][y] = s[x] == s[y] && dp[x + 1][y - 1]
            }
            if(dp[x][y] && y - x + 1 > result.length) {
                result = s.substring(x, y + 1)
            }
        }
    }
    return result
}

fun main() {

    val textList = listOf(
        "babad" to listOf("bab", "aba"),
        "cbbd" to listOf("bb"),
        "eabbaf" to listOf("abba"),
    )

    textList.forEach { item ->
        val isAnswerNotMatch1 = item.second.none { answer ->
            longestPalindrome1(s = item.first) == answer
        }
        val isAnswerNotMatch2 = item.second.none { answer ->
            longestPalindrome2(s = item.first) == answer
        }
        if (isAnswerNotMatch1 || isAnswerNotMatch2) {
            throw RuntimeException("not pass")
        }
    }

}