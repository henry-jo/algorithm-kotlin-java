package greedy

import java.util.*

class BOJ_1931 {
    fun solve() {
        val n = readLine()!!.toInt()
        val meets = mutableListOf<Meet>()

        repeat(n) {
            val (start, end) = readLine()!!.split(" ").map { it.toInt() }
            meets.add(Meet(start, end))
        }

        meets.sortWith(Comparator { o1, o2 ->
            if (o1.end == o2.end) {
                o1.start - o2.start
            } else o1.end - o2.end
        })

        var result = 0
        var end = 0
        meets.forEach {
            if (it.start >= end) {
                result++
                end = it.end
            }
        }

        println(result)
    }

    private data class Meet(
        val start: Int,
        val end: Int
    )
}

fun main(args: Array<String>) {
    BOJ_1931().solve()
}