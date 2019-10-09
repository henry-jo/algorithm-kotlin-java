package dp

import java.util.*

class BOJ_1149 {
    fun solve() {
        val scan = Scanner(System.`in`)

        val n = scan.nextInt()

        // 3가지 경우의 수 누적 최소의 값을 구하기 위해 3가지 dp 결과값을 구해야한다.
        val dp = Array(n) { Array(3) { 0 } }

        dp[0][0] = scan.nextInt()
        dp[0][1] = scan.nextInt()
        dp[0][2] = scan.nextInt()

        for (i in 1 until n) {
            val r = scan.nextInt()
            val g = scan.nextInt()
            val b = scan.nextInt()

            dp[i][0] = r + Math.min(dp[i - 1][1], dp[i - 1][2])
            dp[i][1] = g + Math.min(dp[i - 1][0], dp[i - 1][2])
            dp[i][2] = b + Math.min(dp[i - 1][0], dp[i - 1][1])
        }

        // 3가지 누적 최소값 중에 제일 작은 dp 결과값을 취한다.
        val min = listOf(dp[n - 1][0], dp[n - 1][1], dp[n - 1][2]).min()!!
        println(min)
    }
}

fun main(args: Array<String>) {
    BOJ_1149().solve()
}