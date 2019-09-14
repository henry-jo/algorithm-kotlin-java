package sorting

class BOJ_3047 {
    fun solve() {
        val list = readLine()!!.split(" ").map { it.toInt() }.sorted()
        val alphaList = listOf('A', 'B', 'C')

        val map = list.mapIndexed { index, _ ->
            alphaList[index] to list[index]
        }.toMap()

        val ans = readLine()!!
        ans.forEach {
            print("${map[it]} ")
        }
    }
}

fun main(args: Array<String>) {
    BOJ_3047().solve()
}