package graph

class BOJ_5567 {
    fun solve() {
        val n = readLine()!!.toInt()
        val m = readLine()!!.toInt()
        val isVisited = Array(n + 1) { false }
        val list = mutableListOf<Pair<Int, Int>>()

        repeat(m) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            list.add(Pair(x, y))
            list.add(Pair(y, x))
        }

        for (pair in list) {
            if (pair.first == 1) {
                isVisited[pair.second] = true

                for (pair2 in list) {
                    if (pair2.first == pair.second) {
                        isVisited[pair2.second] = true
                    }
                }
            }
        }

        println(isVisited.sliceArray(2 until isVisited.size).count { it })
    }
}

fun main(args: Array<String>) {
    BOJ_5567().solve()
}