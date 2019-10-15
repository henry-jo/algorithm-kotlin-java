package graph

import java.util.*

class BOJ_1707 {
    fun solve() {
        val (v, e) = readLine()!!.split(" ").map { it.toInt() }

        val linkList = Array<MutableList<Int>>(v + 1) { mutableListOf() }
        val color = Array(v + 1) { 0 }
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

                for (q in linkList[p]) {
                    if (color[q] == 0) {
                        queue.offer(q)
                        color[q] = color[p] * -1
                    } else if (color[p] + color[q] != 0) {
                        check = false
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