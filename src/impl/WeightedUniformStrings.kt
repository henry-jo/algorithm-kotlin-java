package impl

import java.util.*

// Complete the weightedUniformStrings function below.
fun weightedUniformStrings(s: String, queries: Array<Int>): Array<String> {
    val weights = hashSetOf<Int>()

    var prevChar = s[0]
    weights.add(prevChar - 'a' + 1)
    var sum = prevChar - 'a' + 1

    for (i in 1 until s.length) {
        if (prevChar == s[i]) {
            sum += (s[i] - 'a' + 1)
        } else {
            prevChar = s[i]
            sum = s[i] - 'a' + 1
        }

        weights.add(sum)
    }

    val results = Array(queries.size) { " " }
    for (i in 0 until queries.size) {
        if (weights.contains(queries[i])) {
            results[i] = "Yes"
        } else {
            results[i] = "No"
        }
    }

    return results
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val queriesCount = scan.nextLine().trim().toInt()

    val queries = Array<Int>(queriesCount, { 0 })
    for (i in 0 until queriesCount) {
        val queriesItem = scan.nextLine().trim().toInt()
        queries[i] = queriesItem
    }

    val result = weightedUniformStrings(s, queries)

    println(result.joinToString("\n"))
}
