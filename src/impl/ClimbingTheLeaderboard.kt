package impl

import java.util.*

/**
 * Time out
 * TODO : Red Black Binary Tree
 */
// Complete the climbingLeaderboard function below.
fun climbingLeaderboard(scores: Array<Int>, alice: Array<Int>): Array<Int> {

    val rankStackTraces = mutableListOf<Int>()

    alice.forEach { aliceScore ->
        val tempScores = (scores + aliceScore).sortedDescending().distinct()

        rankStackTraces.add(tempScores.indexOf(aliceScore) + 1)
    }

    return rankStackTraces.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val scoresCount = scan.nextLine().trim().toInt()
    val scores = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val aliceCount = scan.nextLine().trim().toInt()
    val alice = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = climbingLeaderboard(scores, alice)

    println(result.joinToString("\n"))
}
