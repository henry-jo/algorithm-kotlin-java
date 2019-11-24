package dp

class BOJ_11052 {
    fun solve() {
        val n = readLine()!!.toInt()
        val list = Array(n + 1) { 0 }
        val dp = Array(n + 1) { 0 }

        readLine()!!.split(" ").forEachIndexed { index, c ->
            list[index + 1] = c.toInt()
        }

        for (i in 1 until list.size) for (j in 1 .. i){
            dp[i] = Math.max(dp[i - j] + list[j], dp[i])
        }

        println(dp.last())
    }
}

fun main(args: Array<String>) {
    BOJ_11052().solve()
}