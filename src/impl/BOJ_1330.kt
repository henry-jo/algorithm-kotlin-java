package impl

class BOJ_1330 {
    fun solve() {
        val (a, b) = readLine()!!.split(" ").map { it.toInt() }

        when {
            a > b -> println(">")
            a < b -> println("<")
            else -> println("==")
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1330().solve()
}