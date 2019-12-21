package programmers.sorting

class Programmers1 {
    fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
        val answer = mutableListOf<Int>()
        for (command in commands) {
            val i = command[0]
            val j = command[1]
            val k = command[2]

            val subArray = array.clone().sliceArray(i - 1 until j).sortedArray()
            answer.add(subArray[k - 1])
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Programmers1().solution(
        intArrayOf(1, 5, 2, 6, 3, 7, 4),
        arrayOf(intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3))
    ).forEach { println(it) }
}