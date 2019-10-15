package dp

class BOJ_1912 {
    fun solve() {
        val n = readLine()!!
        val dp = readLine()!!.split(" ").map { it.toInt() }.toMutableList()

        for(i in 1 until dp.size) {
            dp[i] = Math.max(dp[i], dp[i - 1] + dp[i])
        }

        println(dp.max())
    }
}

fun main(args: Array<String>) {
    BOJ_1912().solve()
}