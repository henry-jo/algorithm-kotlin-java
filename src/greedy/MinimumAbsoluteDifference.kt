package greedy

import java.util.*

// Complete the minimumAbsoluteDifference function below.
fun minimumAbsoluteDifference(arr: Array<Int>): Int {
    /* Timeout Solution
    var ans = Int.MAX_VALUE

    for (i in 0 until arr.size) for (j in (i + 1) until arr.size) {
        val diff = Math.abs(arr[i] - arr[j])
        if (diff == 0) return 0

        ans = Math.min(ans, diff)
    }

    return ans
    */
    arr.sort()

    var ans = Int.MAX_VALUE

    for (i in 0 until arr.size - 1) {
        val diff = Math.abs(arr[i] - arr[i + 1])
        if (diff == 0) return 0

        ans = Math.min(ans, diff)
    }

    return ans
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val result = minimumAbsoluteDifference(arr)

    println(result)
}
