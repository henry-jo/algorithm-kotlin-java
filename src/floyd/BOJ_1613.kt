package floyd

class BOJ_1613 {
    fun solve() {
        val (n, k) = readLine()!!.split(" ").map { it.toInt() }
        val matrix = Array(n + 1) { BooleanArray(n + 1) { false } }

        repeat(k) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            matrix[x][y] = true
        }

        for (i in 1..n) for (u in 1..n) for (v in 1..n) {
            if (matrix[u][i] && matrix[i][v]) matrix[u][v] = true
        }

        val s = readLine()!!.toInt()
        val sb = StringBuilder()

        repeat(s) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }

            when {
                matrix[x][y] -> sb.append(-1)
                matrix[y][x] -> sb.append(1)
                else -> sb.append(0)
            }

            sb.append("\n")
        }

        println(sb.toString())
    }
}

fun main(args: Array<String>) {
    BOJ_1613().solve()
}