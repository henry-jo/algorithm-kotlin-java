package impl

class SelectionSort(private var items: Array<Int>) {

    fun sort() {
        var temp: Int // 자리를 바꿀 때 임시로 사용되는 변수

        // SelectionSort
        for (i in 0 until items.size) {
            for (j in (i + 1) until items.size) {
                if (items[i] > items[j]) {
                    temp = items[i]
                    items[i] = items[j]
                    items[j] = temp
                }
            }
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()

        items.forEach { sb.append("$it ") }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val list = SelectionSort(arrayOf(9, 5, 2, 4, 3))
    list.sort()

    println(list.toString())
}