package dp

class BOJ_2747 {
    fun solve() {
        val n = readLine()!!.toInt()
        val dp = Array(n + 1) { 0 }

        dp[0] = 0
        dp[1] = 1

        for (i in 2 until dp.size) {
            dp[i] = dp[i - 2] + dp[i - 1]
        }

        println(dp.last())
    }
}

fun main(args: Array<String>) {
    BOJ_2747().solve()
}