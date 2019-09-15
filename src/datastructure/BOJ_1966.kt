package datastructure

import java.util.*

class BOJ_1966 {
    fun solve(): Int {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val priorityList = readLine()!!.split(" ").map { it.toInt() }

        val printRequests = priorityList.mapIndexed { index, priority ->
            PrintRequest(index, priority)
        }.toCollection(LinkedList())

        val printOrderResult = mutableListOf<PrintRequest>()

        while (!printRequests.isEmpty()) {
            val request = printRequests.poll()

            printRequests.find { it.priority > request.priority }?.let {
                printRequests.offer(request)
            } ?: printOrderResult.add(request)
        }

        return printOrderResult.indexOf(printOrderResult.find { it.index == m }) + 1
    }
}

data class PrintRequest(
    val index: Int,
    val priority: Int
)

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()
    val sb = StringBuilder()

    repeat(t) {
        sb.append(BOJ_1966().solve()).append("\n")
    }

    print(sb.toString())
}