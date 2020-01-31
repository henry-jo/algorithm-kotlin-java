package programmers.queue

import java.util.*

/**
 * 우선순위 프린터 문제
 */
class Programmers2 {
    fun solution(priorities: IntArray, location: Int): Int {
        val queue = priorities.mapIndexed { index, i ->
            PrintRequest(index, i)
        }.toCollection(LinkedList())

        val resultlist = mutableListOf<Int>()
        while(!queue.isEmpty()) {
            val d = queue.poll()

            if (queue.find { it.priority > d.priority } != null) {
                queue.offer(d)
            } else {
                resultlist.add(d.index)
            }
        }

        return resultlist.indexOf(location) + 1
    }

    data class PrintRequest(
        val index: Int,
        val priority: Int
    )
}

fun main(args: Array<String>) {
    println(
        Programmers2().solution(intArrayOf(2, 1, 3, 2), 2)
    )
}