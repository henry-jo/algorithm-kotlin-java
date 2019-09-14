package sorting

class BOJ_1427 {
    fun solve() {
        val list = readLine()!!.map { it - '0' }.sortedDescending()
        list.forEach {
            print(it)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1427().solve()
}