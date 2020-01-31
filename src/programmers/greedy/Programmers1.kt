package programmers.greedy

class Programmers1 {
    fun solution(n: Int, lost: IntArray, reserve: IntArray): Int {
        val lostCollection = lost.toMutableSet()
        val reserveCollection = reserve.toMutableSet()

        val intersect = lostCollection.intersect(reserveCollection)
        lostCollection.removeAll(intersect)
        reserveCollection.removeAll(intersect)

        reserveCollection.forEach {
            val prev = it - 1
            val next = it + 1

            when {
                lostCollection.contains(prev) -> {
                    lostCollection.remove(prev)
                }
                lostCollection.contains(next) -> {
                    lostCollection.remove(next)
                }
                lostCollection.contains(it) -> {
                    lostCollection.remove(it)
                }
            }
        }

        return n - lostCollection.size
    }
}

fun main(args: Array<String>) {
    println(
        Programmers1().solution(7, intArrayOf(2, 3, 4), intArrayOf(1, 2, 3, 6))
    )
}