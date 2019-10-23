package impl

/**
 * 소수 찾기 문제
 */
class BOJ_1978 {
    fun solve() {
        val n = readLine()!!.toInt()

        val dp = Array(1001) { 1 }

        // 0 not prime, 1 prime
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
        val nums = readLine()!!.split(" ").map { it.toInt() }
        nums.forEach { num ->
            if (dp[num] == 1) {
                ans++
            }
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1978().solve()
}