package impl

/**
 * Created by ByeongChan on 2017. 10. 27..
 *
 * 백준 알고리즘 1912번 풀이 (https://www.acmicpc.net/problem/1912)
 *
 * 가장 큰 연속합 구하기 문제
 * Dynamic Programming
 * Math.max
 */

private fun solve(l: List<Int>): Int {
    var temp = l[0]
    var maximum = l[0]
    for (i in l.indices) {
        if (i == 0) {
            continue
        }
        val n = l[i]
        temp = maxOf(temp + n, n)
        maximum = maxOf(maximum, temp)
    }
    return maximum
}

fun main(args: Array<String>) {
    readLine()
    val data = readLine()!!.split(" ").map { it.toInt() }
    println(solve(data))
}