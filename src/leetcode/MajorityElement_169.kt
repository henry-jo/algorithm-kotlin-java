package leetcode

class MajorityElement_169 {
    fun majorityElement(nums: IntArray): Int {
        val hashMap = HashMap<Int, Int>()
        nums.forEach {
            hashMap[it] = hashMap.getOrDefault(it, 0) + 1
        }

        return hashMap.maxBy { it.value }.key
    }
}
