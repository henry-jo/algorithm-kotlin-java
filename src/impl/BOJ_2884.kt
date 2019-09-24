package impl

class BOJ_2884 {
    fun solve() {
        val (h, m) = readLine()!!.split(" ").map { it.toInt() }

        var resultH = h
        var resultM = m - 45

        if (resultM < 0) {
            resultH -= 1

            if (resultH < 0) {
                resultH = 23
            }

            resultM += 60
        }

        println("$resultH $resultM")
    }
}

fun main(args: Array<String>) {
    BOJ_2884().solve()
}