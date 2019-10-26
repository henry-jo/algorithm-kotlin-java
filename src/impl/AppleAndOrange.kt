package impl

import java.util.*

// Complete the countApplesAndOranges function below.
fun countApplesAndOranges(s: Int, t: Int, a: Int, b: Int, apples: Array<Int>, oranges: Array<Int>): Unit {
    val fallAppleLocations = apples.map { a + it }
    val fallOrangeLocations = oranges.map { b + it }

    val resultAppleCnt = fallAppleLocations.filter { it in s..t }.size
    val resultOrangeCnt = fallOrangeLocations.filter { it in s..t }.size

    println(resultAppleCnt)
    println(resultOrangeCnt)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val st = scan.nextLine().split(" ")

    val s = st[0].trim().toInt()

    val t = st[1].trim().toInt()

    val ab = scan.nextLine().split(" ")

    val a = ab[0].trim().toInt()

    val b = ab[1].trim().toInt()

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val apples = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val oranges = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    countApplesAndOranges(s, t, a, b, apples, oranges)
}
