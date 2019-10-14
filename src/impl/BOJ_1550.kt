package impl

class BOJ_1550 {
    fun solve() {
        val hexStr = readLine()!!
        var ans = 0

        hexStr.forEachIndexed { index, c ->
            ans += ((if (c <= '9') c - '0' else c - 'A' + 10) * Math.pow(
                16.0,
                (hexStr.length - 1 - index).toDouble()
            )).toInt()
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1550().solve()
}