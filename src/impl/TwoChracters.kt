package impl

// Complete the alternate function below.
fun alternate(s: String): Int {
    val distinctCharArray = s.toCharArray().distinct()
    var result = 0

    if (distinctCharArray.size == 1) return 0

    for (i in 0 until distinctCharArray.size) for (j in i + 1 until distinctCharArray.size) {
        val a = distinctCharArray[i]
        val b = distinctCharArray[j]
        var prevChar = ' '
        var len = 0

        for (c in s) {
            if (c == a || c == b) {
                if (prevChar != c) {
                    prevChar = c
                    len++
                } else {
                    len = 0
                    break
                }
            }
        }

        result = Math.max(result, len)
    }

    return result
}

fun main(args: Array<String>) {
    val l = readLine()!!.trim().toInt()

    val s = readLine()!!

    val result = alternate(s)

    println(result)
}
