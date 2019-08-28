package impl

class BOJ_1032 {
    fun solve() {
        val n = readLine()!!.toInt()

        val fileNames = mutableListOf<String>()
        for (i in 0 until n) {
            fileNames.add(readLine()!!)
        }

        val size = fileNames[0].length

        val sb = StringBuilder()
        for (i in 0 until size) {
            val compareChar = fileNames[0][i]
            var flag = true

            for (j in 1 until fileNames.size) {
                if (compareChar != fileNames[j][i]) {
                    flag = false
                }
            }

            sb.append(if (flag) compareChar else '?')
        }

        println(sb.toString())
    }
}

fun main(args: Array<String>) {
    BOJ_1032().solve()
}