package impl

class BOJ_2798 {
    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }
        val list = readLine()!!.split(" ").map { it.toInt() }

        var sum = 0
        for(i in 0 until list.size) for (j in 0 until list.size) for (k in 0 until list.size) {
            if(i != j && j != k && i !=k) {
                if(list[i] + list[j] + list[k] <= m) {
                    sum = Math.max(sum, list[i] + list[j] + list[k])
                }
            }
        }

        println(sum)
    }
}

fun main(args: Array<String>) {
    BOJ_2798().solve()
}