package impl

import java.util.*
import kotlin.math.pow

// Complete the encryption function below.
fun encryption(s: String): String {
    val sb = StringBuilder()
    s.forEach { if (it != ' ') sb.append(it) }

    val valueForEncrypt = sb.toString()
    val valueSize = valueForEncrypt.length

    var criteria = 1
    while (true) {
        if (valueSize <= criteria.toDouble().pow(2.0)) {
            break
        } else {
            criteria++
        }
    }

    sb.clear()
    repeat(criteria) { n ->
        sb.append(valueForEncrypt[n])
        var index = n
        while (index + criteria < valueSize) {
            index += criteria
            sb.append(valueForEncrypt[index])
        }
        sb.append(" ")
    }

    return sb.toString()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = encryption(s)

    println(result)
}
