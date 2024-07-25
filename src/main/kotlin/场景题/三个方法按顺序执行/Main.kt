package 场景题.三个方法按顺序执行

import java.util.concurrent.locks.Condition
import java.util.concurrent.locks.ReentrantLock
import kotlin.concurrent.withLock

private class Main {

    @Volatile
    private var flag = 1

    private val lock = ReentrantLock()

    private val method1Condition = lock.newCondition()
    private val method2Condition = lock.newCondition()
    private val method3Condition = lock.newCondition()

    private fun lockInvoke(
        targetFlag: Int,
        nextFlag: Int,
        targetCondition: Condition,
        nextCondition: Condition,
        action: () -> Unit,
    ) {
        lock.withLock {
            while (flag != targetFlag) {
                targetCondition.await()
            }
            action.invoke()
            flag = nextFlag
            nextCondition.signalAll()
        }
    }

    fun method1() {
        lockInvoke(
            targetFlag = 1, nextFlag = 2,
            targetCondition = method1Condition, nextCondition = method2Condition,
        ) {
            println("<")
        }
    }

    fun method2() {
        lockInvoke(
            targetFlag = 2, nextFlag = 3,
            targetCondition = method2Condition, nextCondition = method3Condition,
        ) {
            println(">")
        }
    }

    fun method3() {
        lockInvoke(
            targetFlag = 3, nextFlag = 1,
            targetCondition = method3Condition, nextCondition = method1Condition,
        ) {
            println("=")
        }
    }

}

/**
 * 多线程环境下, 如何让三个方法按顺序执行
 */
fun main() {
    // 创建三个线程来分别跑几个方法
    val temp = Main()
    listOf(
        {
            temp.method1()
        },
        {
            temp.method2()
        },
        {
            temp.method3()
        },
    ).forEach { runAction ->
        Thread {
            (1..10).forEach { item ->
                runAction.invoke()
                // Thread.sleep(1000)
            }
        }.start()
    }
}