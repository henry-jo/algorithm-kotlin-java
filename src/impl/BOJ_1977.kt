package impl

import kotlin.math.min
import kotlin.math.sqrt

class BOJ_1977 {
    fun solve() {
        val m = readLine()!!.toInt()
        val n = readLine()!!.toInt()

        var sum = 0
        var minVal = Int.MAX_VALUE

        for(i in m .. n) {
            if (sqrt(i.toDouble()) % 1.0f == 0.0) { // 완전제곱수인지 확인
                sum += i
                minVal = min(i, minVal)
            }
        }

        if (sum == 0) {
            println(-1)
        } else {
            println(sum)
            println(minVal)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1977().solve()
}