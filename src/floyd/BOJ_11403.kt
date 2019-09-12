package floyd

import java.util.*

class BOJ_11403 {
    fun solve() {
        with(Scanner(System.`in`)) {
            val size = nextInt()
            val dp = Array(size) { Array(size) { if (nextInt() == 1) 1 else Int.MAX_VALUE } }

            for (k in 0 until size) for (i in 0 until size) for (j in 0 until size) {
                if (dp[i][k] == Int.MAX_VALUE || dp[k][j] == Int.MAX_VALUE) continue
                if (dp[i][j] > dp[i][k] + dp[k][j]) {
                    dp[i][j] = dp[i][k] + dp[k][j]
                }
            }

            for (x in 0 until size) {
                println(dp[x].map { if (it == Int.MAX_VALUE) 0 else 1 }.joinToString(" "))
            }
        }
    }
}

fun main(args: Array<String>) {
    BOJ_11403().solve()
}