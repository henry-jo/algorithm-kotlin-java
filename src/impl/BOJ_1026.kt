package impl

class BOJ_1026 {
    fun solve(n: Int, listA: List<Int>, listB: List<Int>) {
        val sortedListA = listA.sorted()
        val sortedListB = listB.sortedDescending()

        var result = 0

        sortedListA.forEachIndexed { index, a ->
            result += a * sortedListB[index]
        }

        println(result)
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val listA = readLine()!!.split(" ").map { it.toInt() }
    val listB = readLine()!!.split(" ").map { it.toInt() }

    BOJ_1026().solve(n, listA, listB)
}