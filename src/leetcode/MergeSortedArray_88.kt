package leetcode

class MergeSortedArray_88 {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        for (i in m until nums1.size) {
            nums1[i] = nums2[i - m]
        }
        nums1.sort()
    }

    // 속도를 더 줄여야한다면?
    // two pointer

    fun merge2(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
        var pointer1 = m - 1
        var pointer2 = n - 1

        for (i in (nums1.size - 1) downTo 0) {
            // 배열 뒷쪽부터 채워야한다. 그렇지 않으면 nums1 값이 삭제됨

            if (pointer2 < 0) { // point2가 끝나면, 나머지 nums1은 변경없이 유지해도 됨
                break
            }

            // pointer1이 끝나면, 나머지는 nums2(= pointer2)로 채워야함
            // 또는, pointer1 < pointer2일때 nums2로 채워야함
            if (pointer1 < 0 || nums1[pointer1] < nums2[pointer2]) {
                nums1[i] = nums2[pointer2--]
            } else {
                nums1[i] = nums1[pointer1--]
            }
        }
    }
}