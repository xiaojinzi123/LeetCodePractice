package 算法.同构字符串

import org.junit.Assert

private fun isIsomorphic(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }
    if (s1.isEmpty()) {
        return false
    }
    val asciiArray1 = IntArray(256).apply {
        this.fill(element = -1)
    }
    val asciiArray2 = BooleanArray(256).apply {
        this.fill(element = false)
    }
    for (index in s1.indices) {
        val s1ItemCode = s1.elementAt(index = index).code
        val s2ItemCode = s2.elementAt(index = index).code
        if(asciiArray1[s1ItemCode] == -1 && !asciiArray2[s2ItemCode]) {
            asciiArray1[s1ItemCode] = s2ItemCode
            asciiArray2[s2ItemCode] = true
        } else {
            if (asciiArray1[s1ItemCode] != s2ItemCode) {
                return false
            }
        }
    }
    return true
}

fun main() {

    val questionAndAnswerList = listOf(
        ("egg" to "add") to true,
        ("foo" to "bar") to false,
        ("paper" to "title") to true,
        ("badc" to "baba") to false,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            isIsomorphic(s1 = question.first, s2 = question.second) == answer
        }
    )

}