package impl

class BOJ_1919 {

    private val ALPHA = 26

    fun solve() {
        val str1 = readLine()!!
        val str2 = readLine()!!

        val alphabets1 = Array(ALPHA) { 0 }
        val alphabets2 = Array(ALPHA) { 0 }

        str1.forEach {
            alphabets1[it - 'a']++
        }
        str2.forEach {
            alphabets2[it - 'a']++
        }

        var result = 0
        for (i in 0 until ALPHA) {
            result += Math.abs(alphabets1[i] - alphabets2[i])
        }

        println(result)
    }
}

fun main(args: Array<String>) {
    BOJ_1919().solve()
}