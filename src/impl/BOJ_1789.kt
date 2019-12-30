package impl

class BOJ_1789 {
    fun solve() {
        val s = readLine()!!.toLong()
        var sum = 0L
        var i = 1

        while(sum + i <= s) {
            sum += i
            i++
        }

        println(i - 1)
    }
}

fun main(args: Array<String>) {
    BOJ_1789().solve()
}