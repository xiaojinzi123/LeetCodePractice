package support

inline fun <reified T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun IntArray.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun randomIntArray(size: Int = 20, range: IntRange = 0..500): IntArray {
    return IntArray(size) { range.random() }
}