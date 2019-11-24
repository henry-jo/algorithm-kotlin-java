package impl

class BOJ_4948 {
    fun solve(n: Int): Int {
        val dp = Array((2 * n) + 1) { 1 }

        if (dp.size < 2) {
            return 0
        }

        dp[0] = 0
        dp[1] = 0

        for (i in 2 until dp.size) {
            var j = 2
            while (i * j < dp.size) {
                dp[i * j] = 0
                j++
            }
        }

        var ans = 0
        for (i in n + 1 until dp.size) {
            if (dp[i] == 1) ans++
        }

        return ans
    }
}

fun main(args: Array<String>) {
    while (true) {
        val input = readLine()!!.toInt()
        if (input == 0) break

        println(BOJ_4948().solve(input))
    }
}