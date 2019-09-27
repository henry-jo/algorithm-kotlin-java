package impl

class BubbleSort(private var items: Array<Int>) {
    fun sort() {
        var temp = 0 // 자리를 바꿀 때 임시로 사용되는 변수

        for (i in 0 until items.size) {
            for (j in 1 until items.size - i) {
                if (items[j - 1] > items[j]) {
                    temp = items[j - 1]
                    items[j - 1] = items[j]
                    items[j] = temp
                }
            }
        }
    }

    fun improveSort() {
        var numberSwitch: Boolean

        do {
            numberSwitch = false

            for (i in 0 until items.size - 1) {
                if (items[i + 1] < items[i]) {
                    val temp = items[i + 1]
                    items[i + 1] = items[i]
                    items[i] = temp

                    numberSwitch = true
                }
            }
        } while (numberSwitch)
    }

    override fun toString(): String {
        val sb = StringBuilder()
        items.forEach { sb.append("$it ") }

        return sb.toString()
    }
}

fun main(args: Array<String>) {
    val list = BubbleSort(arrayOf(9, 5, 2, 4, 3))
    list.sort()

    println(list.toString())

    val list2 = BubbleSort(arrayOf(9, 5, 2, 4, 3))
    list2.improveSort()

    println(list2.toString())
}