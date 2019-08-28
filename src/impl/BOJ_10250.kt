package impl

fun main(args: Array<String>) {
    val NEW_LINE = "\n"

    val t = readLine()!!.toInt()

    val sb = StringBuilder()
    for (i in 0 until t) {
        val (h, w, n) = readLine()!!.split(" ").map { it.toInt() }

        sb.append("%d%02d".format((n - 1) % h + 1, (n - 1) / h + 1)).append(NEW_LINE)
    }

    println(sb.toString())
}