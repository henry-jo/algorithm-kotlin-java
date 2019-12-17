package greedy

class BOJ_1449 {
    fun solve() {
        val (n, l) = readLine()!!.split(" ").map { it.toInt() }
        val leakPoints = readLine()!!.split(" ").map { it.toInt() }.sorted()

        var ans = 1
        var startPoint = leakPoints[0] - 0.5
        for (i in 1 until leakPoints.size) {
            if (leakPoints[i] > startPoint + l) {
                startPoint = leakPoints[i] - 0.5
                ans++
            }
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1449().solve()
}