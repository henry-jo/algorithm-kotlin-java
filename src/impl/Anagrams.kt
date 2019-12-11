import java.util.*

// Complete the anagram function below.
fun anagram(s: String): Int {
    if (s.length % 2 != 0) {
        return -1
    }

    val middleIndex = s.length / 2

    val firstStr = s.substring(0 until middleIndex)
    val secondStr = s.substring(middleIndex until s.length)

    val alphabets = Array(26) { 0 }
    firstStr.forEach {
        alphabets[it - 'a']++
    }

    secondStr.forEach {
        if (alphabets[it - 'a'] > 0) {
            alphabets[it - 'a']--
        }
    }

    return alphabets.sum()
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = anagram(s)

        println(result)
    }
}
