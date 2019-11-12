package dp

import java.util.*

// Complete the maxSubsetSum function below.
fun maxSubsetSum(arr: Array<Int>): Int {
    val dp = mutableListOf<Int>()

    for (i in 0 until arr.size) {
        when(i) {
            0 -> dp.add(Math.max(arr[i], 0))
            1 -> dp.add(Math.max(Math.max(arr[i], dp[i - 1]), 0))
            else -> dp.add(Math.max(Math.max(dp[i - 1], dp[i - 2]), arr[i] + dp[i - 2]))
        }
    }

    return dp.max()!!
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = maxSubsetSum(arr)

    println(res)
}
