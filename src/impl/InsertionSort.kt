package impl

class InsertionSort(private var items: Array<Int>) {
    fun sort() {
        for (i in 0 until items.size - 1) {
            val KEY = items[i + 1]
            var j = i

            while (j >= 0) { // KEY부터 하나씩 내려가며 값을 비교한다.
                if (items[j] <= KEY) {
                    break
                }

                items[j + 1] = items[j]
                j--
            }
            items[j + 1] = KEY
        }
    }

    override fun toString(): String {
        val sb = StringBuilder()

        items.forEach { sb.append("$it ") }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val list = InsertionSort(arrayOf(9, 5, 2, 4, 3))
    list.sort()

    println(list.toString())
}