package dfs

import java.util.*

class BOJ_11724 {

    private var n = 0
    private var result = 0
    private var matrix: Array<IntArray> = arrayOf()
    private val isVisited = mutableListOf<Int>()

    fun solve() {
        val st = StringTokenizer(readLine(), " ")

        n = st.nextToken().toInt()
        val m = Integer.parseInt(st.nextToken())

        matrix = Array(n + 1) { IntArray(n + 1) { 0 } }

        repeat(m) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            matrix[x][y] = 1
            matrix[y][x] = 1
        }

        for (i in 1..n) {
            if (!isVisited.contains(i)) {
                result++
                dfs(i)
            }
        }

        println(result)
    }

    private fun dfs(node: Int) {
        isVisited.add(node)

        for (i in 1..n) {
            if (matrix[node][i] == 1 && !isVisited.contains(i)) {
                dfs(i)
            }
        }
    }
}

fun main(args: Array<String>) {
    BOJ_11724().solve()
}