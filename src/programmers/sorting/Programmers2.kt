package programmers.sorting

import java.util.*


class Programmers2 {
    fun solution(numbers: IntArray): String {
        var strings = numbers.map { it.toString() }

        strings = strings.sortedWith(Comparator { o1, o2 ->
            (o2 + o1).compareTo(o1 + o2)
        })

        if(strings[0] == "0") return strings[0]

        val sb = StringBuilder()
        strings.forEach {
            sb.append(it)
        }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    println(
        Programmers2().solution(intArrayOf(3, 30, 34, 5, 9))
    )
}