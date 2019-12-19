package programmers.stack

class Programmers1 {
    fun solution(heights: IntArray): IntArray {
        val answer = IntArray(heights.size) { 0 }

        for(i in heights.size - 1 downTo 1){
            for(j in i - 1 downTo 0) {
                if (heights[i] < heights[j]) {
                    answer[i] = j + 1
                    break
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    Programmers1().solution(intArrayOf())
}