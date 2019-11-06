package impl

import java.util.*

// Complete the makeAnagram function below.
fun makeAnagram(a: String, b: String): Int {
    var sum = 0
    val alphabets = Array(26) { 0 }

    a.forEach {
        alphabets[it - 'a']++
    }

    b.forEach {
        alphabets[it - 'a']--
    }

    alphabets.forEach {
        sum += Math.abs(it)
    }

    return sum
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val a = scan.nextLine()

    val b = scan.nextLine()

    val res = makeAnagram(a, b)

    println(res)
}
