package leetcode

class PascalsTriangle_118 {
    fun generate(numRows: Int): List<List<Int>> {
        val result = mutableListOf<List<Int>>()

        for (i in 0 until numRows) {
            val rows = mutableListOf<Int>()

            for (j in 0 .. i) {
                if ((j == 0) || (j == i)) {
                    rows.add(1)
                } else {
                    val prevRows = result[i - 1]
                    rows.add(prevRows[j - 1] + prevRows[j])
                }
            }

            result.add(rows)
        }

        return result
    }
}

fun main(args: Array<String>) {
    PascalsTriangle_118().generate(5)
}