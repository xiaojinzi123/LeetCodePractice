package 算法.support

inline fun <reified T> Array<T>.swap(i: Int, j: Int) {
    val temp = this[i]
    this[i] = this[j]
    this[j] = temp
}

fun IntArray.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp
}

fun randomIntArray(size: Int = 20, range: IntRange = 0..500): IntArray {
    return IntArray(size) { range.random() }
}