package floyd

class BOJ_1389 {

    private val INF = 10000000

    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val matrix = Array(n + 1) { IntArray(n + 1) { INF } }

        repeat(m) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            matrix[x][y] = 1
            matrix[y][x] = 1
        }

        for (k in 1..n) for (u in 1..n) for (v in 1..n) {
            if(matrix[u][k] == INF || matrix[k][v] == INF) continue

            matrix[u][v] = Math.min(matrix[u][v], matrix[u][k] + matrix[k][v])
        }

        val linkCntList = matrix.map { it.sum() }
        println(linkCntList.indexOf(linkCntList.min()))
    }
}

fun main(args: Array<String>) {
    BOJ_1389().solve()
}