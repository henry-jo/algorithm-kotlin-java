package impl

class BOJ_1157 {

    private val ALPHA_CNT = 26

    fun solve(str: String) {
        val alphabets = Array(ALPHA_CNT) { 0 }

        str.toUpperCase().forEach {
            alphabets[it - 'A']++
        }

        val maxCnt = alphabets.max()!!

        val maxFirstIndex = alphabets.indexOfFirst { it == maxCnt }
        val maxLastIndex = alphabets.indexOfLast { it == maxCnt }

        if (maxFirstIndex != maxLastIndex) {
            println("?")
        } else {
            println((maxFirstIndex + 'A'.toInt()).toChar())
        }
    }
}

fun main(args: Array<String>) {
    val inputStr = readLine()!!

    BOJ_1157().solve(inputStr)
}