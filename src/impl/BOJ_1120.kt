package impl

class BOJ_1120 {
    fun solve() {
        val (a, b) = readLine()!!.split(" ")

        val diffLen = b.length - a.length

        var ans = b.length

        for(i in 0 .. diffLen) {
            var diff = 0

            a.forEachIndexed { j, c ->
                if (c != b[i + j]) diff++
            }

            ans = Math.min(ans, diff)
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1120().solve()
}