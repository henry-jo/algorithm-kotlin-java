package impl

import java.util.*

// Complete the twoStrings function below.
fun twoStrings(s1: String, s2: String): String {
    val wordSet = s1.toHashSet()
    s2.forEach {
        if (wordSet.contains(it)) return "YES"
    }

    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s1 = scan.nextLine()

        val s2 = scan.nextLine()

        val result = twoStrings(s1, s2)

        println(result)
    }
}
