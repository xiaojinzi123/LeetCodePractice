package 算法.正则表达式匹配

import org.junit.Assert

private fun isMatch(s: String, p: String): Boolean {
    if (s.isEmpty() && p.isEmpty()) {
        return true
    }
    if (p.all { it == '*' }) {
        return true
    }
    if (s.isEmpty() || p.isEmpty()) {
        return false
    }
    var sIndex = 0
    var pIndex = 0
    while (sIndex < s.length && pIndex < p.length) {
        val sChar = p.elementAt(index = sIndex)
        val pChar = p.elementAt(index = pIndex)
        if (pChar == '.') {
            sIndex++
            pIndex++
        } else if (pChar == '*') {
            if (pIndex >= p.length - 1) {
                return true
            } else {
                val pCharNext = p.elementAt(index = pIndex + 1)
                if (pCharNext == sChar) {
                    sIndex++
                    pIndex += 2
                } else {
                    sIndex++
                    pIndex++
                }
            }
        } else {
            if (sChar == pChar) {
                sIndex++
                pIndex++
            } else {
                return false
            }
        }
    }
    return sIndex == s.length && pIndex == p.length
}

fun main() {

    val questionAndAnswerList = listOf(
        ("" to "*") to true,
        ("aa" to "a") to false,
        ("aa" to "a*") to true,
        ("ab" to ".*") to true,
        ("aab" to "c*a*b") to false,
        ("mississippi" to "mis*is*p*.") to false,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            isMatch(s = question.first, p = question.second) == answer
        }
    )

}