package greedy

class BOJ_1541 {
    fun solve() {
        val op = readLine()!!

        val plusOp = op.split("-")
        val minusOp = mutableListOf<Int>()
        plusOp.forEach {
            minusOp.add(it.split("+").map { it.toInt() }.sum())
        }

        var ans = minusOp[0]
        for(i in 1 until minusOp.size) {
            ans -= minusOp[i]
        }

        println(ans)
    }
}

fun main(args: Array<String>) {
    BOJ_1541().solve()
}