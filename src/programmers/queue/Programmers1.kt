package programmers.queue

import java.util.*

class Programmers1 {
    fun solution(progresses: IntArray, speeds: IntArray): IntArray {
        val jobPeriod = LinkedList<Int>()
        for (i in 0 until progresses.size) {
            val remains = 100 - progresses[i]
            var period = remains / speeds[i]

            if (remains % speeds[i] != 0) period++

            jobPeriod.offer(period)
        }

        val answer = mutableListOf<Int>()
        var criteria = jobPeriod.poll()
        var cnt = 1
        while (!jobPeriod.isEmpty()) {
            val p = jobPeriod.poll()

            if (p <= criteria) {
                cnt++
            } else {
                answer.add(cnt)
                criteria = p
                cnt = 1
            }
        }
        answer.add(cnt)

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Programmers1().solution(intArrayOf(93, 30, 55), intArrayOf(1, 30, 5)).forEach { println(it) }
}