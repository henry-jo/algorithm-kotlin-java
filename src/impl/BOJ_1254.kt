package impl

class BOJ_1254 {

    private val ALPHA = 26

    fun solve() {
        val str = readLine()!!

        var result = str.length
        for (i in 0 until str.length) {
            if(isPalindrome(str.substring(i))) {
                result += i

                break
            }
        }

        println(result)
    }

    private fun isPalindrome(str: String): Boolean {
        for (i in 0 until str.length / 2) {
            if (str[i] != str[str.length - 1 - i]) {
                return false
            }
        }

        return true
    }
}

fun main(args: Array<String>) {
    BOJ_1254().solve()
}

