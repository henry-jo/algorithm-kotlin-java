package graph

import java.util.*

/**
 * 이분 그래프
 */
class BOJ_1707 {
    fun solve() {
        val (v, e) = readLine()!!.split(" ").map { it.toInt() }

        val linkList = Array<MutableList<Int>>(v + 1) { mutableListOf() }
        val color = Array(v + 1) { 0 } // bfs, dfs와는 다르게 방문 여부를 color로 저장한다.
        repeat(e) {
            val (a, b) = readLine()!!.split(" ").map { it.toInt() }

            linkList[a].add(b)
            linkList[b].add(a)
        }

        var check = true
        val queue: Queue<Int> = LinkedList()
        for (i in 1 until linkList.size) {
            if (!check) break
            if (color[i] != 0) continue

            queue.offer(i)
            color[i] = 1

            while (!queue.isEmpty()) {
                val p = queue.poll()

                for (q in linkList[p]) { // 연결되어 있는 노드 방문
                    if (color[q] == 0) { // 방문하지 않은 노드라면
                        queue.offer(q)
                        color[q] = color[p] * -1 // 인접한 노드와 다른 color를 부여
                    } else if (color[p] + color[q] != 0) { // 만일 방문된 노드라면 같은 color인지 확인
                        check = false // 인접한 두 노드가 같은 color라면 이분 그래프가 아니므로 false
                        break
                    }
                }
            }
        }

        println(if (check) "YES" else "NO")
    }
}

fun main(args: Array<String>) {
    var t = readLine()!!.toInt()

    while (t-- > 0) {
        BOJ_1707().solve()
    }
}