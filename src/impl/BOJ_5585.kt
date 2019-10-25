package impl

class BOJ_5585 {
    fun solve() {
        val price = readLine()!!.toInt()
        var change = 1000 - price

        val coins = intArrayOf(500, 100, 50, 10, 5, 1)
        var ans = 0

        for (coin in coins) {
            if(change / coin > 0) {
                ans += change / coin
                change %= coin
            }
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_5585().solve()
}