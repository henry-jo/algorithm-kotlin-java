package programmers.bfs

import java.util.*

/**
 * 네트워크 연결 개수 문제
 */
class Programmers1 {
    fun solution(n: Int, computers: Array<IntArray>): Int {
        var answer = 0
        val isVisited = BooleanArray(computers.size) { false }

        repeat(n) {
            if (!isVisited[it]) {
                bfs(it, computers, isVisited)
                answer++
            }
        }

        return answer
    }

    private fun bfs(startN: Int, computers: Array<IntArray>, isVisited: BooleanArray) {
        val queue = LinkedList<Int>()
        queue.offer(startN)

        while (!queue.isEmpty()) {
            val k = queue.poll()

            repeat(computers.size) { n ->
                if (k != n && computers[k][n] == 1 && !isVisited[n]) {
                    queue.offer(n)
                    isVisited[n] = true
                }
            }
        }
    }
}

fun main(args: Array<String>) {
    println(
        Programmers1().solution(3, arrayOf(intArrayOf(1, 1, 0), intArrayOf(1, 1, 0), intArrayOf(0, 0, 1)))
    )
}