package sorting

class BOJ_11650 {
    fun solve(){
        val n = readLine()!!.toInt()
        val list = mutableListOf<Pair<Int, Int>>()

        repeat(n) {
            val (x, y) = readLine()!!.split(" ").map { it.toInt() }
            list.add(Pair(x, y))
        }

        list.sortBy { it.second }
        list.sortBy { it.first }

        list.forEach {
            println("${it.first} ${it.second}")
        }
    }
}

fun main(args: Array<String>) {
    BOJ_11650().solve()
}