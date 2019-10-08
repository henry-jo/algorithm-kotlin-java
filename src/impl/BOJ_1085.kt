package impl

class BOJ_1085 {
    fun solve() {
        val (x, y, w, h) = readLine()!!.split(" ").map { it.toInt() }

        println(listOf(x, y, w - x, h - y).min())
    }
}

fun main(args: Array<String>) {
    BOJ_1085().solve()
}