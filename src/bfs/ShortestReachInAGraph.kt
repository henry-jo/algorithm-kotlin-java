package bfs

import java.util.*

private fun solve() {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }
    val edges = mutableListOf<Pair<Int, Int>>()

    repeat(m) {
        val (x, y) = readLine()!!.split(" ").map { it.toInt() }

        edges.add(Pair(x, y))
        edges.add(Pair(y, x))
    }

    val resultList = Array(n + 1) { -1 }
    val startNode = readLine()!!.toInt()
    val queue = LinkedList<Pair<Int, Int>>()
    queue.add(Pair(startNode, 1))

    var weight = 0
    while (queue.isNotEmpty()) {
        val pair = queue.poll()
        val node = pair.first
        val level = pair.second
        weight = level * 6

        for ((x, y) in edges) {
            if (x == node && resultList[y] == -1) {
                queue.add(Pair(y, level + 1))
                resultList[y] = weight
            }
        }
    }

    val sb = StringBuilder()
    for (i in 1 until resultList.size) {
        if (i == startNode) continue
        sb.append("${resultList[i]} ")
    }
    println(sb.toString())
}

fun main(args: Array<String>) {
    val t = readLine()!!.toInt()

    repeat(t) {
        solve()
    }
}

