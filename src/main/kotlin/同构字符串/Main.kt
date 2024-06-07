package 同构字符串

import org.junit.Assert

private fun isIsomorphic(s1: String, s2: String): Boolean {
    if (s1.length != s2.length) {
        return false
    }
    if (s1.isEmpty()) {
        return false
    }
    val asciiArray = IntArray(256).apply {
        this.fill(element = -1)
    }
    for (index in s1.indices) {
        val arrIndex = s1.elementAt(index = index).code
        if(asciiArray[arrIndex] == -1) {
            asciiArray[arrIndex] = s2.elementAt(index = index).code
        } else {
            if (asciiArray[arrIndex] != s2.elementAt(index = index).code) {
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
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            isIsomorphic(s1 = question.first, s2 = question.second) == answer
        }
    )

}