package floyd

class BOJ_1238 {
    fun solve() {
        val (n, m, x) = readLine()!!.split(" ").map { it.toInt() }
        val matrix = Array(n + 1) { IntArray(n + 1) { 100_001 } }

        repeat(n) {
            matrix[it][it] = 0
        }

        repeat(m) {
            val (i, j, k) = readLine()!!.split(" ").map { it.toInt() }
            matrix[i][j] = k
        }

        // floyd
        for (k in 1..n) for (i in 1..n) for (j in 1..n) {
            matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j])
        }

        // X 지점까지 오고가는 거리 중 max값을 구함
        var max = 0
        for (i in 1..n) {
            max = Math.max(max, matrix[i][x] + matrix[x][i])
        }

        println(max)
    }
}

fun main(args: Array<String>) {
    BOJ_1238().solve()
}