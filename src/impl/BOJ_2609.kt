package impl

class BOJ_2609 {
    fun solve() {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }

        val mulValue = a * b

        while (b != 0) {
            val tmp = b
            b = a % b
            a = tmp
        }

        println(a)
        println(mulValue / a)
    }
}

fun main(args: Array<String>) {
    BOJ_2609().solve()
}