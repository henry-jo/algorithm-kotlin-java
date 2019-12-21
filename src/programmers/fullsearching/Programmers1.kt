package programmers.fullsearching

class Programmers1 {
    fun solution(answers: IntArray): IntArray {
        val result = Array(3) { 0 }

        val picks = arrayOf(
            intArrayOf(1, 2, 3, 4, 5),
            intArrayOf(2, 1, 2, 3, 2, 4, 2, 5),
            intArrayOf(3, 3, 1, 1, 2, 2, 4, 4, 5, 5)
        )

        for(i in 0 until 3) {
            var cnt = 0
            answers.forEachIndexed { index, j ->
                if (j == picks[i][index % picks[i].size]) {
                    cnt++
                }
            }
            result[i] = cnt
        }

        val answer = mutableListOf<Int>()
        val maxValue = result.max()!!

        for(i in 0 until result.size) {
            if(maxValue == result[i]) {
                answer.add(i + 1)
            }
        }

        return answer.toIntArray()
    }
}

fun main(args: Array<String>) {
    Programmers1().solution(intArrayOf(1,3,2,4,2)).forEach { println(it) }
}