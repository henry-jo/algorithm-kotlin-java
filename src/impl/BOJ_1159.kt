package impl

class BOJ_1159 {

    private val ALPHA_CNT = 26

    fun solve() {
        val n = readLine()!!.toInt()
        val alphabets = Array(ALPHA_CNT) { 0 }

        repeat(n) {
            val playerName = readLine()!!
            alphabets[playerName[0] - 'a']++
        }

        val resultAlphaIndexList = mutableListOf<Int>()

        alphabets.forEachIndexed { index, i ->
            if (i >= 5) resultAlphaIndexList.add(index)
        }

        if (resultAlphaIndexList.isEmpty()) {
            println("PREDAJA")
        } else {
            val sb = StringBuilder()
            resultAlphaIndexList.forEach {
                sb.append((it + 'a'.toInt()).toChar())
            }

            println(sb.toString())
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1159().solve()
}