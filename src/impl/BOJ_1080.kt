package impl

class BOJ_1080 {
    fun solve() {
        val (n, m) = readLine()!!.split(" ").map { it.toInt() }

        val matrix1 = Array(n) { Array(m) { 0 } }
        val matrix2 = Array(n) { Array(m) { 0 } }

        for (i in 0 until n) {
            val inputStr = readLine()!!

            inputStr.forEachIndexed { j, c ->
                matrix1[i][j] = c - '0'
            }
        }

        for (i in 0 until n) {
            val inputStr = readLine()!!

            inputStr.forEachIndexed { j, c ->
                matrix2[i][j] = c - '0'
            }
        }

        var ans = 0
        for (i in 0 until n - 2) for (j in 0 until m - 2) {
            if (matrix1[i][j] != matrix2[i][j]) {
                reverseMatrix(i, j, matrix1)
                ans++
            }
        }

        for (i in 0 until n) for (j in 0 until m) {
            if (matrix1[i][j] != matrix2[i][j]) {
                ans = -1
            }
        }

        println(ans)
    }

    private fun reverseMatrix(x: Int, y: Int, matrix: Array<Array<Int>>) {
        for (i in x until x + 3) for (j in y until y + 3) {
            matrix[i][j] = if (matrix[i][j] == 0) 1 else 0
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1080().solve()
}