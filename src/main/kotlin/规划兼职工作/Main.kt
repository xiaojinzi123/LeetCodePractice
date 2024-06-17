package 规划兼职工作

import org.junit.Assert
import kotlin.math.max

private data class Job(
    val startTime: Int,
    val endTime: Int,
    val profit: Int,
)

/**
 * 计算出最大的报酬
 * 定义 dp 方程
 * dp[i] 表示前 i 个工作的最大报酬
 * 对工作的结束时间进行排序
 * 如果第 i 份工作选择, 那么 dp[i] = dp[j] + jobs[i].profit
 * j 是最后一个结束时间小于等于jobs[i].startTime 的工作
 * 如果第 i 份工作不选择, 那么 dp[i] = dp[i - 1]
 * 那么 dp 方程就是：dp[i] = max(dp[i - 1], dp[j] + jobs[i].profit)
 * dp[0] 就是 0
 */
private fun jobScheduling(jobs: Array<Job>): Int {
    // 按照结束时间排序
    jobs.sortBy { it.endTime }
    val dp = IntArray(jobs.size + 1) {
        0
    }
    for(i in (1..dp.lastIndex)) {
        // 拿到工作
        val job = jobs[i - 1]
        // 计算 j 的位置, 小于等于 job.startTime
        var j = 0
        // 最终 j 指向的 job 是 endTime > job.startTime 的
        // dp 中用到的 j 则需要 j - 1 + 1
        // - 1 是因为 j 需要指向最后一个满足条件的
        // +1 是因为 jobs 的下标和 dp 的下标差值导致
        while (jobs[j].endTime <= job.startTime) {
            j++
        }
        dp[i] = max(
            dp[i - 1], dp[j] + jobs[i - 1].profit
        )
    }
    return dp.last()
}

fun main() {

    val startTime: IntArray

    startTime.toTypedArray()

    val jobList1 = arrayOf(
        Job(1, 3, 50),
        Job(3, 6, 70),
        Job(2, 4, 10),
        Job(3, 5, 40),
    )
    val jobList2 = arrayOf(
        Job(1, 3, 20),
        Job(4, 6, 70),
        Job(6, 9, 60),
        Job(3, 10, 100),
        Job(2, 5, 20),
    )
    val questionAndAnswerList = listOf(
        jobList1 to 120,
        jobList2 to 150,
    )

    Assert.assertTrue(
        questionAndAnswerList.all { (question, answer) ->
            jobScheduling(
                jobs = question,
            ) == answer
        }
    )
}