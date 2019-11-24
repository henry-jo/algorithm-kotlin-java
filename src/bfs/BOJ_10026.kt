package bfs

import java.util.*

class BOJ_10026 {
    fun solve() {
        val n = readLine()!!.toInt()
        val dxy = listOf(Pair(-1, 0), Pair(1, 0), Pair(0, -1), Pair(0, 1))

        val matrix1 = Array(n) { Array(n) { ' ' } }
        val matrix2 = Array(n) { Array(n) { ' ' } }

        val isVisited = Array(n) { Array(n) { false } }

        for (i in 0 until n) {
            readLine()!!.forEachIndexed { j, c ->
                matrix1[i][j] = c
                matrix2[i][j] = if (c == 'G') 'R' else c
            }
        }

        var ans1 = 0
        var ans2 = 0

        for (i in 0 until n) for (j in 0 until n) {
            if (isVisited[i][j]) continue

            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.offer(Pair(i, j))
            isVisited[i][j] = true

            while (queue.isNotEmpty()) {
                val point = queue.poll()

                for((dx, dy) in dxy) {
                    val x = point.first + dx
                    val y = point.second + dy

                    if (x in (0 until n) && y in (0 until n) && !isVisited[x][y] && matrix1[point.first][point.second] == matrix1[x][y]) {
                        queue.offer(Pair(x, y))
                        isVisited[x][y] = true
                    }
                }
            }

            ans1++
        }

        isVisited.forEach { it.fill(false) }

        for (i in 0 until n) for (j in 0 until n) {
            if (isVisited[i][j]) continue

            val queue: Queue<Pair<Int, Int>> = LinkedList()
            queue.offer(Pair(i, j))
            isVisited[i][j] = true

            while (queue.isNotEmpty()) {
                val point = queue.poll()

                for((dx, dy) in dxy) {
                    val x = point.first + dx
                    val y = point.second + dy

                    if (x in (0 until n) && y in (0 until n) && !isVisited[x][y] && matrix2[point.first][point.second] == matrix2[x][y]) {
                        queue.offer(Pair(x, y))
                        isVisited[x][y] = true
                    }
                }
            }

            ans2++
        }

        println("$ans1 $ans2")
    }
}

fun main(args: Array<String>) {
    BOJ_10026().solve()
}