package impl

import java.util.*

// Complete the isValid function below.
fun isValid(s: String): String {
    val alphabets = Array(26) { 0 }

    s.forEach {
        alphabets[it - 'a']++
    }

    val countList = alphabets.toSet().filter { it != 0 }

    if (countList.size == 1) {
        return "YES"
    }

    if (countList.size > 2) {
        return "NO"
    }

    val maxCnt = countList.max()!!
    val minCnt = countList.min()!!

    val maxCntAlpha = alphabets.filter { it == maxCnt }
    val minCntAlpha = alphabets.filter { it == minCnt }

    return if (maxCntAlpha.size == 1 && (maxCnt - 1) == minCnt) {
        "YES"
    } else if (minCntAlpha.size == 1 && (minCnt - 1) == 0) {
        "YES"
    } else {
        "NO"
    }
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = isValid(s)

    println(result)
}
