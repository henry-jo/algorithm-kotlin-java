package impl

import java.util.*

// Complete the checkMagazine function below.
fun checkMagazine(magazine: Array<String>, note: Array<String>): Unit {
    val magazineMap = mutableMapOf<String, Int>()
    magazine.forEach { word ->
        if (magazineMap[word] == null) {
            magazineMap[word] = 1
        } else {
            magazineMap[word] = magazineMap[word]!!.plus(1)
        }
    }

    var flag = true

    run loop@{
        note.forEach { word ->
            if (magazineMap[word] == null) {
                flag = false
                return@loop
            }

            if (magazineMap[word]!! == 0) {
                flag = false
                return@loop
            }

            magazineMap[word] = magazineMap[word]!!.minus(1)
        }
    }

    println(if (flag) "Yes" else "No")
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val mn = scan.nextLine().split(" ")

    val m = mn[0].trim().toInt()

    val n = mn[1].trim().toInt()

    val magazine = scan.nextLine().split(" ").toTypedArray()

    val note = scan.nextLine().split(" ").toTypedArray()

    checkMagazine(magazine, note)
}
