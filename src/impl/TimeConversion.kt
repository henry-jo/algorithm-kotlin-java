package impl

import java.util.*

/*
 * Complete the timeConversion function below.
 */
fun timeConversion(s: String): String {
    val isPm = s.endsWith("PM")

    var (hh, mm, ss) = s.replace("AM", "")
        .replace("PM", "")
        .split(":")
        .map { it.toInt() }

    if (isPm && hh != 12) {
        hh += 12
    } else if (!isPm && hh == 12) {
        hh -= 12
    }

    val sb = StringBuilder()
    sb.append(hh.convertTimeFormat()).append(":").append(mm.convertTimeFormat()).append(":").append(ss.convertTimeFormat())

    return sb.toString()
}

fun Int.convertTimeFormat() = if (this < 10) "0$this" else this.toString()

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val s = scan.nextLine()

    val result = timeConversion(s)

    println(result)
}
