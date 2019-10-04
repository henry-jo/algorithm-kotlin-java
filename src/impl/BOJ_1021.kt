package impl

import java.util.*

class BOJ_1021 {
    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }

        val rotateQueue = LinkedList<Int>()
        for (i in 1..n) {
            rotateQueue.add(i)
        }

        val findDatas = readLine()!!.split(" ").map { it.toInt() }
        var opCnt = 0

        findDatas.forEach { target ->

            while (true) {
                val pos = rotateQueue.indexOf(target)
                val left = pos
                val right = rotateQueue.size - 1 - pos

                if(pos == 0) {
                    rotateQueue.removeFirst()
                    break
                }

                if (left <= right) {
                    rotateQueue.addLast(rotateQueue.removeFirst())
                    opCnt++
                } else {
                    rotateQueue.addFirst(rotateQueue.removeLast())
                    opCnt++
                }
            }
        }

        println(opCnt)
    }
}

fun main(args: Array<String>) {
    BOJ_1021().solve()
}