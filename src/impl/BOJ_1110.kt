package impl

class BOJ_1110 {
    fun solve() {
        val initN = readLine()!!

        var n = initN
        var ans = 0
        while(true) {
            val nn = n.toInt()

            val x = nn / 10
            val y = nn % 10

            val z = x + y

            n = y.toString() + z.toString().last()
            ans++

            if (n.toInt() == initN.toInt()) {
                break
            }
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1110().solve()
}