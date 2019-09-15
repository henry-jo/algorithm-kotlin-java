package impl

class BOJ_1213 {

    private val ALPHA = 26

    fun solve() {
        val str = readLine()!!
        val alphabets = Array(ALPHA) { 0 }

        str.forEach {
            alphabets[it - 'A']++
        }

        var oddCnt = 0
        var center = ' '
        alphabets.forEachIndexed { index, cnt ->
            if (cnt % 2 != 0) {
                oddCnt++
                center = (index + 'A'.toInt()).toChar()
            }
        }

        val sb = StringBuilder()
        if (oddCnt > 1) {
            sb.append("I'm Sorry Hansoo")
        } else {
            alphabets.forEachIndexed { index, cnt ->
                repeat(cnt / 2) {
                    sb.append((index + 'A'.toInt()).toChar())
                }
            }

            val reverse = StringBuilder(sb).reverse()

            if (oddCnt != 0) {
                sb.append(center)
            }

            sb.append(reverse)
        }

        println(sb.toString())
    }
}

fun main(args: Array<String>) {
    BOJ_1213().solve()
}