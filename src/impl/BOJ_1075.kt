package impl

class BOJ_1075 {
    fun solve(n: Int, m: Int) {
        var nn = n / 100
        nn *= 100

        while (nn % m != 0) nn++

        nn %= 100
        if (nn < 10) {
            println("0$nn")
        } else {
            println(nn)
        }
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val m = readLine()!!.toInt()

    BOJ_1075().solve(n, m)
}