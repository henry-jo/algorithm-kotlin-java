package sorting

import java.util.*

// TODO : Timeout Error
// Complete the minimumSwaps function below.
fun minimumSwaps(arr: Array<Int>): Int {
    var ans = 0

    for (i in 0 until arr.size - 1) {

        var minimum = arr[i]
        var minimumIndex = i

        for (j in i + 1 until arr.size) {
            if (minimum > arr[j]) {
                minimum = arr[j]
                minimumIndex = j
            }
        }

        if (minimumIndex != i) {
            val tmp = arr[i]
            arr[i] = arr[minimumIndex]
            arr[minimumIndex] = tmp

            ans++
        }
    }

    return ans
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val arr = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    val res = minimumSwaps(arr)

    println(res)
}
