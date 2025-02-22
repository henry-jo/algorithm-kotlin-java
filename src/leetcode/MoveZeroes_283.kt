package leetcode

class MoveZeroes_283 {
    fun moveZeroes(nums: IntArray): Unit {
        var zeroCount = 0

        nums.forEachIndexed { index, i ->
            if (i == 0) {
                zeroCount++
            } else {
                nums[index - zeroCount] = i // 이걸 한번에 생각하지 못했다.
            }
        }

        repeat(zeroCount) {
            nums[nums.size - 1 - it] = 0
        }
    }
}
