package impl

class ReverseString {
    fun solve1(str: String) {
        val sb = StringBuilder()

        for (i in str.length - 1 downTo 0) {
            sb.append(str[i])
        }

        println(sb.toString())
    }

    fun solve2(str: String) {
        val sb = StringBuilder(str)

        for (i in 0..str.length / 2) {
            sb.setCharAt(i, str[str.length - 1 -i])
            sb.setCharAt(str.length - 1 - i, str[i])
        }

        println(sb.toString())
    }

    fun solve3(str: String) {
        println(str.reversed())
    }
}

fun main(args: Array<String>) {
    val exampleStr = "ABCDE"

    ReverseString().solve1(exampleStr)
    ReverseString().solve2(exampleStr)
    ReverseString().solve3(exampleStr)
}