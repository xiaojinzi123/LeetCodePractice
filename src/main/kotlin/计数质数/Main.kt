package 计数质数

private fun isPrime(value: Int): Boolean {
    if (value < 0) {
        throw IllegalArgumentException("value must be positive")
    }
    if (value <= 2) {
        return true
    }
    var i = 2
    while (i * i <= value) {
        if (value % i == 0) {
            return false
        }
        i++
    }
    return true
}

private fun countPrimes1(n: Int): Int {
    var count = 0
    for (index in 1 until n) {
        if (isPrime(index)) {
            println("value = $index")
            count++
        }
    }
    return count
}

fun main() {

    println(countPrimes1(12))

}