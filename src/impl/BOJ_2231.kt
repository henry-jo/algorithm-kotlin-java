package impl

class BOJ_2231 {
    fun solve() {
        val n = readLine()!!.toInt()

        var ans = n - (9 * n.toString().length)
        while(true) {
            var copy = ans
            var sum = ans

            while (copy != 0) {
                sum += copy % 10
                copy /= 10
            }

            if(sum == n || ans == n) {
                break
            }

            ans++
        }

        if (ans == n) {
            println(0)
        } else {
            println(ans)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_2231().solve()
}