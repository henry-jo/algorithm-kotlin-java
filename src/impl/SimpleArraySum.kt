package impl

import java.util.*

/*
 * Complete the simpleArraySum function below.
 */
fun simpleArraySum(ar: Array<Int>) = ar.sum()

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val arCount = scan.nextLine().trim().toInt()

    val ar = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = simpleArraySum(ar)

    println(result)
}
