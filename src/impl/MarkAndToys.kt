package impl

import java.util.*

// Complete the maximumToys function below.
fun maximumToys(prices: Array<Int>, k: Int): Int {
    var ans = 0
    var sum = 0

    run loop@{
        prices.sorted().forEach {
            sum += it
            if (sum > k) {
                return@loop
            }
            ans++
        }
    }

    return ans
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val nk = scan.nextLine().split(" ")

    val n = nk[0].trim().toInt()

    val k = nk[1].trim().toInt()

    val prices = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = maximumToys(prices, k)

    println(result)
}
