package sorting

import java.util.*

class BOJ_1181 {
    fun solve() {
        val n = readLine()!!.toInt()
        val wordList = mutableListOf<String>()

        repeat(n) {
            wordList.add(readLine()!!)
        }

        val word = wordList.distinct().toTypedArray()

        // 직접 정렬 구현
        Arrays.sort(word) { o1, o2 ->
            if (o1.length == o2.length) {
                o1.compareTo(o2)
            } else o1.length - o2.length
        }

        word.forEach {
            println(it)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1181().solve()
}