package floyd

import kotlin.math.min

class BOJ_11404 {

    private val INF = Int.MAX_VALUE

    fun solve() {
        val n = readLine()!!.toInt()
        val m = readLine()!!.toInt()

        val matrix = Array(n + 1) { Array(n + 1) { INF } }
        for (i in 1 until matrix.size) for (j in 1 until matrix[i].size) {
            if (i == j) matrix[i][j] = 0
        }

        repeat(m) {
            val (x, y, cost) = readLine()!!.split(" ").map { it.toInt() }
            matrix[x][y] = min(matrix[x][y], cost)
        }

        for (k in 1 until n + 1) for (i in 1 until n + 1) for (j in 1 until n + 1) {
            if (matrix[i][k] == INF || matrix[k][j] == INF) continue
            if (matrix[i][j] > matrix[i][k] + matrix[k][j]) {
                matrix[i][j] = matrix[i][k] + matrix[k][j]
            }
        }

        for (i in 1 until matrix.size) {
            println(
                matrix[i].sliceArray(1 until matrix[i].size).map { if (it == INF) "0" else it }.joinToString(
                    separator = " "
                )
            )
        }
    }
}

fun main(args: Array<String>) {
    BOJ_11404().solve()
}