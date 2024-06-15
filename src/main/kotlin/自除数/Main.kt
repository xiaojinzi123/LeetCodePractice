package 自除数

import org.junit.Assert

private fun selfDividingNumbers1(left: Int, right: Int): List<Int> {
    if (left < 1 || left > right) {
        throw IllegalArgumentException("left must be greater than 0 and less than or equal to right")
    }
    val result = mutableListOf<Int>()
    for (n in left..right) {
        if (n in 2..9) {
            result.add(n)
        } else {
            var temp1 = n % 10
            var temp2 = n
            while (temp2 > 0) {
                if (temp1 == 0 || n % temp1 != 0) {
                    break
                }
                temp2 /= 10
                temp1 = temp2 % 10
            }
            if (temp2 == 0) {
                result.add(n)
            }
        }
    }
    return result
}

fun main() {

    val questionAndAnswerList = listOf(
        (1 to 22) to listOf(
            1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 12, 15, 22
        ),
        (47 to 85) to listOf(
            48, 55, 66, 77
        ),
    )

    val result = questionAndAnswerList.all { (item, answer) ->
        selfDividingNumbers1(
            left = item.first, right = item.second,
        ) == answer
    }

    Assert.assertTrue(result)

}