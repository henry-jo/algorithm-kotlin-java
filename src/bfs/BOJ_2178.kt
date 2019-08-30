package bfs

import java.util.*

class BOJ_2178 {
    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val matrix = Array(n) { IntArray(m) { 0 } }
        val visit = Array(n) { IntArray(m) { -1 } }

        for (i in 0 until matrix.size) {
            val s = readLine()!!

            for (j in 0 until matrix[i].size) {
                matrix[i][j] = s[j] - '0'
            }
        }

        val queue = LinkedList<Pair<Int, Int>>()
        queue.add(Pair(0, 0))
        visit[0][0] = 1

        val dxy = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

        while (!queue.isEmpty()) {
            val (x, y) = queue.poll()

            for ((dx, dy) in dxy) {
                val nx = x + dx
                val ny = y + dy

                if ((nx in 0 until n) && (ny in 0 until m) && (matrix[nx][ny] == 1) && (visit[nx][ny] == -1)) {
                    queue.add(Pair(nx, ny))
                    visit[nx][ny] = visit[x][y] + 1
                }
            }
        }

        println(visit[n - 1][m - 1])
    }
}

fun main(args: Array<String>) {
    BOJ_2178().solve()
}