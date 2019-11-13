package impl

import java.util.*

// Complete the isBalanced function below.
fun isBalanced(s: String): String {
    val stack = Stack<Char>()

    s.forEach { c ->
        if (c in listOf('{', '[', '(')) stack.push(c)

        if (c in listOf('}', ']', ')')) {
            if (stack.isEmpty()) return "NO"

            val brackets = stack.pop()

            when (c) {
                '}' -> if (brackets != '{') return "NO"
                ']' -> if (brackets != '[') return "NO"
                ')' -> if (brackets != '(') return "NO"
            }
        }
    }

    if (stack.isNotEmpty()) return "NO"

    return "YES"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val t = scan.nextLine().trim().toInt()

    for (tItr in 1..t) {
        val s = scan.nextLine()

        val result = isBalanced(s)

        println(result)
    }
}
