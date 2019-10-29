package impl

import java.util.*

// Complete the kangaroo function below.
fun kangaroo(x1: Int, v1: Int, x2: Int, v2: Int): String {
    fun getKangaroo1Position(n: Int) = x1 + v1 * (n - 1)
    fun getKangaroo2Position(n: Int) = x2 + v2 * (n - 1)

    var prefDiff = Math.abs(x2 - x1)

    for (time in 1..10_000) {
        val kangaroo1 = getKangaroo1Position(time)
        val kangaroo2 = getKangaroo2Position(time)

        if (kangaroo1 == kangaroo2) return "YES"
        if (Math.abs(kangaroo2 - kangaroo1) > prefDiff) return "NO"

        prefDiff = Math.abs(kangaroo2 - kangaroo1)
    }

    return "NO"
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val x1V1X2V2 = scan.nextLine().split(" ")

    val x1 = x1V1X2V2[0].trim().toInt()

    val v1 = x1V1X2V2[1].trim().toInt()

    val x2 = x1V1X2V2[2].trim().toInt()

    val v2 = x1V1X2V2[3].trim().toInt()

    val result = kangaroo(x1, v1, x2, v2)

    println(result)
}
