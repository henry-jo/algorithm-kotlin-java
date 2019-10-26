package impl

import java.math.BigInteger
import java.util.*

// Complete the extraLongFactorials function below.
fun extraLongFactorials(n: Int): Unit {
    var result = BigInteger.ONE

    for (i in 0 until n) {
        result = result.multiply((i + 1).toBigInteger())
    }

    println(result)
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    extraLongFactorials(n)
}
