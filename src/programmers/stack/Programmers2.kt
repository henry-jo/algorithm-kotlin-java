package programmers.stack

import java.util.*

/**
 * 레이저와 쇠막대 문제
 */
class Programmers2 {
    fun solution(arrangement: String): Int {
        val stack = Stack<Char>()
        var answer = 0

        arrangement.forEachIndexed { index, c ->
            if (c == '(') {
                stack.push(c)
            } else {
                stack.pop()

                if (arrangement[index - 1] != '(') {
                    answer++
                } else {
                    answer += stack.size
                }
            }
        }

        return answer
    }
}

fun main(args: Array<String>) {
    println(
        Programmers2().solution("(()()())")
    )
}