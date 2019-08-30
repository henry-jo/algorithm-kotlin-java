package bfs

import java.util.*

class BOJ_1260 {

    val sb = StringBuilder()

    fun solve() {
        val (n, m, v) = readLine()!!.split(" ").map { it.toInt() }
        val matrix = Array(n + 1) { IntArray(n + 1) { 0 } }
        val visited = mutableListOf<Int>()

        repeat(m) {
            val (a, b) = readLine()!!.split(" ").map { it.toInt() }
            matrix[a][b] = 1
            matrix[b][a] = 1
        }

        dfs(v, matrix, visited)

        visited.clear()
        sb.append("\n")

        bfs(v, matrix, visited)

        print(sb.toString())
    }

    private fun dfs(start: Int, matrix: Array<IntArray>, visited: MutableList<Int>) {
        visited.add(start)
        sb.append("$start ")

        for(y in 1 until matrix.size) {
            if (matrix[start][y] == 1 && !visited.contains(y)) {
                dfs(y, matrix, visited)
            }
        }
    }

    private fun bfs(start: Int, matrix: Array<IntArray>, visited: MutableList<Int>) {
        val queue = LinkedList<Int>()
        queue.add(start)
        visited.add(start)

        while(!queue.isEmpty()) {
            val x = queue.poll()
            sb.append("$x ")

            for (y in 1 until matrix.size) {
                if (matrix[x][y] == 1 && !visited.contains(y)) {
                    queue.add(y)
                    visited.add(y)
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1260().solve()
}