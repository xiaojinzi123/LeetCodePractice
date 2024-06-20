import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * 测试
 */
suspend fun main() {

    val scope = MainScope()

    println("当前线程：${Thread.currentThread().id}, ${Thread.currentThread().name}")

    val job = scope.launch(
        context = Dispatchers.Unconfined,
    ) {
        println("当前线程：${Thread.currentThread().id}, ${Thread.currentThread().name}")
        delay(1000)
        println("当前线程：${Thread.currentThread().id}, ${Thread.currentThread().name}")
    }

    job.join()

    println("结束了")

}