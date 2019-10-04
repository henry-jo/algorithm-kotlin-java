package impl

class BOJ_1037 {

    fun solve(list: List<Int>) {
        val sortedList = list.sorted()

        println(sortedList[0] * sortedList.last())
    }
}

fun main(args: Array<String>) {
    val n = readLine()!!.toInt()
    val list = readLine()!!.split(" ").map { it.toInt() }

    BOJ_1037().solve(list)
}