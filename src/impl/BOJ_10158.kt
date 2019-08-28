package impl

fun main(args: Array<String>) {
    val (w, h) = readLine()!!.split(" ").map { it.toInt() }
    val (p, q) = readLine()!!.split(" ").map { it.toInt() }
    val t = readLine()!!.toInt()

    val x = if (((p + t) / w) % 2 == 0) {
        (p + t) % w
    } else {
        w - ((p + t) % w)
    }

    val y = if (((q + t) / h) % 2 == 0) {
        (q + t) % h
    } else {
        h - ((q + t) % h)
    }

    println("$x $y")
}