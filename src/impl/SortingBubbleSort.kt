package impl

import java.util.*

// Complete the countSwaps function below.
fun countSwaps(a: Array<Int>): Unit {
    var swapCnt = 0

    for (i in 0 until a.size) {
        for (j in 0 until a.size - 1) {
            // Swap adjacent elements if they are in decreasing order
            if (a[j] > a[j + 1]) {
                swap(a, j, j + 1)
                swapCnt++
            }
        }
    }

    println("Array is sorted in $swapCnt swaps.")
    println("First Element: ${a.first()}")
    println("Last Element: ${a.last()}")
}

private fun swap(a: Array<Int>, i: Int, j: Int) {
    val tmp = a[j]
    a[j] = a[i]
    a[i] = tmp
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val n = scan.nextLine().trim().toInt()

    val a = scan.nextLine().split(" ").map { it.trim().toInt() }.toTypedArray()

    countSwaps(a)
}
