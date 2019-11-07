package impl

import java.util.*

// Complete the alternatingCharacters function below.
fun alternatingCharacters(s: String): Int {

    var prevAlpha = s[0]
    var alterMaxCnt = 1

    for (i in 0 until s.length) {
        if (prevAlpha != s[i]) {
            prevAlpha = s[i]
            alterMaxCnt++
        }
    }

    return s.length - alterMaxCnt
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = alternatingCharacters(s)

        println(result)
    }
}
