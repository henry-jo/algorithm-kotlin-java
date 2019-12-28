package datastructure

/**
 * HashMap + Sorting
 */
class BOJ_1302 {
    fun solve() {
        val n = readLine()!!.toInt()
        val hashMap = HashMap<String, Int>()

        repeat(n) {
            val bookTitle = readLine()!!

            if (hashMap.containsKey(bookTitle)) {
                hashMap[bookTitle] = hashMap[bookTitle]!!.plus(1)
            } else {
                hashMap[bookTitle] = 1
            }
        }

        var bookTitleList = hashMap.keys.toList()
        bookTitleList = bookTitleList.sortedWith(Comparator { o1, o2 ->
            if (hashMap[o1] == hashMap[o2]) {
                o2.compareTo(o1) // 같은 경우 사전 기준 빠른 순
            } else {
                hashMap[o1]!! - hashMap[o2]!!
            }
        })

        println(bookTitleList.last())
    }
}

fun main(args: Array<String>) {
    BOJ_1302().solve()
}