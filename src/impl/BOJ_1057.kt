package impl

/**
 * 토너먼트 문제
 */
class BOJ_1057 {
    fun solve() {
        var (n, kim, lim) = readLine()!!.split(" ").map { it.toInt() }

        var ans = 0

        while (kim != lim) {
            kim = kim / 2 + kim % 2
            lim = lim / 2 + lim % 2

            ans++
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1057().solve()
}