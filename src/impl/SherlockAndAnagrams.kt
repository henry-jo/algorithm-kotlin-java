package impl

import java.util.*

// Complete the sherlockAndAnagrams function below.
fun sherlockAndAnagrams(s: String): Int {

    var ans = 0

    for (i in 1 until s.length) {
        val subStringList = mutableListOf<String>()

        for (j in 0 until s.length) {
            if (i + j <= s.length) {
                subStringList.add(s.substring(j, i + j))
            }
        }

        for (k in 0 until subStringList.size) {
            for (l in k + 1 until subStringList.size) {
                if (isAnagrams(subStringList[k], subStringList[l])) {
                    ans++
                }
            }
        }
    }

    return ans
}

fun isAnagrams(s1: String, s2: String): Boolean {
    val alphabets = Array(26) { 0 }
    s1.forEach {
        alphabets[it - 'a']++
    }
    s2.forEach {
        alphabets[it - 'a']--
    }

    return alphabets.find { it != 0 } == null
}

fun main(args: Array<String>) {
    val scan = Scanner(System.`in`)

    val q = scan.nextLine().trim().toInt()

    for (qItr in 1..q) {
        val s = scan.nextLine()

        val result = sherlockAndAnagrams(s)

        println(result)
    }
}
