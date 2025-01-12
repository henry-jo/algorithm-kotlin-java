package leetcode

class SingleNumber_136 {
    fun singleNumber(nums: IntArray): Int {
        // 어떤 자료구조를 이용할지? HashSet?
        val duplicateChecker = hashSetOf<Int>()
        duplicateChecker.add(nums.first())

        for (i in 1 until nums.size) {
            if (duplicateChecker.contains(nums[i])) {
                duplicateChecker.remove(nums[i])
            } else {
                duplicateChecker.add(nums[i])
            }
        }

        return duplicateChecker.first()

        // 위와 같은 방법으로 하면 꽤나 느리다.
        // 가장 빠른 방법은 XOR을 활용하는 방법으로 보인다.
    }
}

fun main() {
    println(
        SingleNumber_136().singleNumber(
            intArrayOf(2,2,1)
        )
    )
}
