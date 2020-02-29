package impl

import kotlin.math.abs

class BOJ_2851 {
    fun solve() {
        val scoreList = mutableListOf<Int>()
        repeat(10) {
            scoreList.add(readLine()!!.toInt())
        }

        var result = 0
        for (score in scoreList) {
            if (result + score >= 100) {
                if (abs(100 - result) >= abs(100 - (result + score))) {
                    result += score
                }

                break
            }
            result += score
        }
        println(result)
    }
}

fun main(args: Array<String>) {
    BOJ_2851().solve()
}