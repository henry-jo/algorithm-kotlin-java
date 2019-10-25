package bfs

import java.util.*

class BOJ_2667 {
    fun solve() {
        val n = readLine()!!.toInt()
        val matrix = Array(n) { Array(n) { 0 } }

        val dxy = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

        repeat(n) { i ->
            val line = readLine()!!

            line.forEachIndexed { j, c ->
                matrix[i][j] = c - '0'
            }
        }

        val ansList = mutableListOf<Int>()
        for (i in 0 until n) for (j in 0 until n) {

            if (matrix[i][j] == 1) {
                var ans = 0
                val q: Queue<Pair<Int, Int>> = LinkedList()
                q.offer(Pair(i, j))
                matrix[i][j] = 0

                while (!q.isEmpty()) {
                    val (x, y) = q.poll()
                    ans++

                    for ((dx, dy) in dxy) {
                        val nx = x + dx
                        val ny = y + dy

                        if ((nx in 0 until n) && (ny in 0 until n) && matrix[nx][ny] == 1) {
                            q.offer(Pair(nx, ny))
                            matrix[nx][ny] = 0
                        }
                    }
                }

                ansList.add(ans)
            }
        }

        ansList.sort()

        println(ansList.size)
        ansList.forEach {
            println(it)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_2667().solve()
}