package impl

import java.util.*

// Complete the rotLeft function below.
fun rotLeft(a: Array<Int>, d: Int): Array<Int> {
    val queue = a.toCollection(LinkedList())

    repeat(d) {
        queue.add(queue.poll())
    }

    return queue.toTypedArray()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nd = scan.nextLine().split(" ")

    val n = nd[0].trim().toInt()

    val d = nd[1].trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = rotLeft(a, d)

    println(result.joinToString(" "))
}
