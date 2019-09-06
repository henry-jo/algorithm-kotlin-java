package bfs

import java.util.*

class BOJ_2606 {
    fun solve() {
        val n = readLine()!!.toInt()
        val k = readLine()!!.toInt()

        val matrix = Array(n + 1) { IntArray(n + 1) { 0 } }

        repeat(k) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }

            matrix[x][y] = 1
            matrix[y][x] = 1
        }

        bfs(matrix)
    }

    private fun bfs(matrix: Array<IntArray>) {
        val visited = mutableListOf<Int>()
        val queue = LinkedList<Int>()

        queue.add(1)
        visited.add(1)

        while (!queue.isEmpty()) {
            val i = queue.poll()

            for (j in 1 until matrix.size) {
                if (!visited.contains(j) && matrix[i][j] == 1) {
                    queue.add(j)
                    visited.add(j)
                }
            }
        }

        println(visited.size - 1)
    }
}

fun main(args: Array<String>) {
    BOJ_2606().solve()
}