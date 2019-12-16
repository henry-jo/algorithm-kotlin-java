package impl

class BOJ_1065 {
    fun solve() {
        val n = readLine()!!.toInt()

        var ans = 0
        for (i in 1..n) {
            if (isHansu(i)) ans++
        }

        println(ans)
    }

    private fun isHansu(n: Int): Boolean {
        if (n < 100) return true

        val copyCharArray = n.toString().toCharArray()
        val diff = (copyCharArray[1] - '0') - (copyCharArray[0] - '0')
        for (i in 1 until copyCharArray.size - 1) {
            if ((copyCharArray[i + 1] - '0') - (copyCharArray[i] - '0') != diff) return false
        }

        return true
    }
}

fun main(args: Array<String>) {
    BOJ_1065().solve()
}