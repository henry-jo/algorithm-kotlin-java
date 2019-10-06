package impl

class BOJ_1049 {
    fun solve(n: Int, packPrices: MutableList<Int>, piecePrices: MutableList<Int>) {
        val minPackPrice = packPrices.min()!!
        val minPiecePrice = piecePrices.min()!!

        val k = n / 6
        val reminder = n % 6

        val case1 = (if (reminder != 0) k + 1 else k) * minPackPrice // case 1 : 모두 팩으로 구매
        val case2 = k * minPackPrice + reminder * minPiecePrice // case 2 : 팩 + 피스
        val case3 = n * minPiecePrice // case 3 : 올 피스

        println(arrayOf(case1, case2, case3).min())
    }
}

fun main(args: Array<String>) {
    val (n, m) = readLine()!!.split(" ").map { it.toInt() }

    val packPrices = mutableListOf<Int>()
    val piecePrices = mutableListOf<Int>()

    repeat(m) {
        val (packPrice, piecePrice) = readLine()!!.split(" ").map { it.toInt() }

        packPrices.add(packPrice)
        piecePrices.add(piecePrice)
    }

    BOJ_1049().solve(n, packPrices, piecePrices)
}