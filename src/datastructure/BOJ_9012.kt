package datastructure

import java.util.*

class BOJ_9012 {
    fun solve(): String {
        val inputStr = readLine()!!
        val stack = Stack<Char>()

        inputStr.forEach { char ->
            when (char) {
                '(' -> stack.push(char)
                ')' -> {
                    if (stack.isEmpty()) {
                        return "NO"
                    } else {
                        stack.pop()
                    }
                }
            }
        }

        if (stack.isNotEmpty()) {
            return "NO"
        }

        return "YES"
    }
}

fun main(args: Array<String>) {
    var testCaseCnt = readLine()!!.toInt()
    val sb = StringBuilder()

    while (testCaseCnt-- > 0) {
        sb.append(BOJ_9012().solve()).append("\n")
    }

    println(sb.toString())
}