package impl

class BOJ_8958 {
    fun solve() {
        val input = readLine()!!

        var result = 0
        var accum = 0

        input.forEach { c ->
            when(c) {
                'O' -> {
                    accum += 1
                    result += accum
                }
                'X' -> accum = 0
            }
        }

        println(result)
    }
}

fun main(args: Array<String>) {
    var testCase = readLine()!!.toInt()

    while (testCase-- > 0){
        BOJ_8958().solve()
    }
}