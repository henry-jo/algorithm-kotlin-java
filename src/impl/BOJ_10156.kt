package impl

fun main(args: Array<String>) {
    val (n, k, m) = readLine()!!.split(" ").map { it.toInt() }
    println(Math.max(n * k - m, 0))
}