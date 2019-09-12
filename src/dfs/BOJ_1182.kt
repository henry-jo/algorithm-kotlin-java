package dfs

import java.util.*

class BOJ_1182 {

    private var n = 0
    private var s = 0
    private var sequence = listOf<Int>()

    private var result = 0

    fun solve() {
        val st = StringTokenizer(readLine(), " ")
        n = st.nextToken().toInt()
        s = st.nextToken().toInt()

        sequence = readLine()!!.split(" ").map { it.toInt() }

        for (i in 0 until sequence.size) {
            dfs(i, sequence[i])
        }

        println(result)
    }

    private fun dfs(index: Int, sum: Int) {
        if (sum == s) {
            result++
        }

        for (v in index + 1 until sequence.size) {
            dfs(v, sum + sequence[v])
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1182().solve()
}

