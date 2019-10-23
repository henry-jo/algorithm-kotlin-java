package impl

/**
 * 최소 공배수 구하는 문제
 * 유클레드 호제법 사용
 */
class BOJ_1934 {
    fun solve(): Int {
        var (a, b) = readLine()!!.split(" ").map { it.toInt() }

        val minValue = a * b

        while (true) {
            if (b == 0) {
                return minValue / a
            }

            val tmp = b
            b = a % b
            a = tmp
        }
    }
}

fun main(args: Array<String>) {
    var t = readLine()!!.toInt()
    val sb = StringBuilder()

    while (t-- > 0) {
        sb.append(BOJ_1934().solve()).append("\n")
    }

    println(sb.toString())
}