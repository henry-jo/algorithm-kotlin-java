package greedy

class BOJ_11047 {
    fun solve() {
        var (n, k) = readLine()!!.split(" ").map { it.toInt() }
        val coins = Array(n) { 0 }
        repeat(n) { i ->
            coins[i] = readLine()!!.toInt()
        }

        var ans = 0
        coins.sortedArrayDescending().forEach { coin ->
            ans += k / coin
            k %= coin
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_11047().solve()
}