package bfs

import java.util.*

/**
 * bfs에 몇번 진입하는지를 묻는 문제
 */

class BOJ_1012 {
    fun solve(): String {
        val (m, n, k) = readLine()!!.split(" ").map { it.toInt() }

        val matrix = mutableListOf<Point>()
        for (i in 0 until k) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }

            matrix.add(Point(x, y))
        }

        return bfs(matrix).toString()
    }

    fun bfs(matrix: List<Point>): Int {
        val q: Queue<Point> = LinkedList()
        var cnt = 0

        for (point in matrix) {
            if (point.isVisited) {
                continue
            }

            q.add(point)
            point.isVisited = true

            while (!q.isEmpty()) {
                val p = q.poll()

                for (u in matrix) {
                    // 다음 식으로 인접한 좌표인지 확인한다
                    if (!u.isVisited && (Math.abs(p.x - u.x) + Math.abs(p.y - u.y) == 1)) {
                        q.add(u)
                        u.isVisited = true
                    }
                }
            }

            cnt++
        }

        return cnt
    }

    data class Point(
        val x: Int,
        val y: Int,
        var isVisited: Boolean = false
    )
}

fun main(args: Array<String>) {
    var t = readLine()!!.toInt()

    val sb = StringBuilder()
    while (t-- > 0) {
        sb.append(
            BOJ_1012().solve()
        ).append("\n")
    }

    println(sb.toString())
}