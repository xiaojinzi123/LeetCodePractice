package support

import kotlin.random.Random

/**
 * 一个简单的用数组实现的二叉堆
 */
class ArrayHeap<T : Comparable<T>>(
    // 是否是最大堆
    val isBigHeap: Boolean = false,
) {

    private val mDataList = mutableListOf<T>()

    private fun swap(
        index1: Int,
        index2: Int,
    ) {
        val temp = mDataList[index1]
        mDataList[index1] = mDataList[index2]
        mDataList[index2] = temp
    }

    private fun shiftUp() {
        var tempIndex = mDataList.lastIndex
        while (tempIndex > 0) {
            val parentIndex = (tempIndex - 1) / 2
            val parentValue = mDataList[parentIndex]
            if (isBigHeap) {
                if (parentValue < mDataList[tempIndex]) {
                    swap(
                        index1 = tempIndex, index2 = parentIndex,
                    )
                }
            } else {
                if (parentValue > mDataList[tempIndex]) {
                    swap(
                        index1 = tempIndex, index2 = parentIndex,
                    )
                }
            }
            tempIndex = parentIndex
        }
    }

    private fun shiftDown() {
        var tempIndex = 0
        while (true) {
            val leftChildIndex = tempIndex * 2 + 1
            val rightChildIndex = leftChildIndex + 1
            val targetIndex = mDataList.getOrNull(leftChildIndex)?.let { leftValue ->
                mDataList.getOrNull(rightChildIndex)?.let { rightValue ->
                    if (isBigHeap) {
                        if (leftValue > rightValue) {
                            leftChildIndex
                        } else {
                            rightChildIndex
                        }
                    } else {
                        if (leftValue < rightValue) {
                            leftChildIndex
                        } else {
                            rightChildIndex
                        }
                    }
                } ?: leftChildIndex
            } ?: tempIndex
            if (isBigHeap) {
                if (mDataList[tempIndex] < mDataList[targetIndex]) {
                    swap(index1 = tempIndex, index2 = targetIndex)
                    tempIndex = targetIndex
                } else {
                    break
                }
            } else {
                if (mDataList[tempIndex] > mDataList[targetIndex]) {
                    swap(index1 = tempIndex, index2 = targetIndex)
                    tempIndex = targetIndex
                } else {
                    break
                }
            }
        }
    }

    fun add(value: T) {
        mDataList.add(
            element = value,
        )
        shiftUp()
    }

    fun pop(): T? {
        val value = mDataList.getOrNull(index = 0)
        if (value != null) {
            if (mDataList.size > 1) {
                mDataList.set(
                    index = 0,
                    element = mDataList.removeAt(
                        index = mDataList.lastIndex,
                    )
                )
                shiftDown()
            } else {
                mDataList.removeAt(0)
            }
        }
        return value
    }

}

fun main() {

    val heap1 = ArrayHeap<Int>()
    val heap2 = ArrayHeap<Int>(
        isBigHeap = true,
    )

    repeat(times = 5) {
        heap1.add(value = 100)
        heap2.add(value = 100)
    }

    repeat(times = 20) {
        heap1.add(
            value = Random.nextInt(
                from = 0, until = 1000,
            )
        )
        heap2.add(
            value = Random.nextInt(
                from = 0, until = 1000,
            )
        )
    }

    var temp: Int? = null
    do {
        temp = heap1.pop()
        if (temp != null) {
            println("value = $temp")
        }
    } while (temp != null)

    println("分割线==================================================")

    do {
        temp = heap2.pop()
        if (temp != null) {
            println("value = $temp")
        }
    } while (temp != null)


}