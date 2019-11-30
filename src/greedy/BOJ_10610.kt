package greedy

class BOJ_10610 {
    fun solve() {
        val n = readLine()!!
        val nums = Array(10) { 0 }

        var sum = 0
        n.forEach { c ->
            val num = c - '0'
            nums[num]++
            sum += num
        }

        if (sum % 3 != 0 || nums[0] == 0) {
            println("-1")
            return
        }

        val sb = StringBuilder()
        for (i in nums.size - 1 downTo 0) {
            while (nums[i]-- > 0) {
                sb.append(i)
            }
        }

        println(sb.toString())
    }
}

fun main(args: Array<String>) {
    BOJ_10610().solve()
}