package search

class BOJ_1436 {

    private val INFIX_STR = "666"

    fun solve(n: Int) {
        var cnt = 0
        var index = 0

        while (cnt != n) {
            if ((++index).toString().contains(INFIX_STR)) cnt++
        }

        println(index.toString())
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    BOJ_1436().solve(n)
}