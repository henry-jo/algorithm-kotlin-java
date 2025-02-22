package leetcode

class PalindromeLinkedList_234 {
    fun isPalindrome(head: ListNode?): Boolean {
        var cur = head
        val list = mutableListOf<Int>()

        while (cur != null) {
            list.add(cur.value)
            cur = cur.next
        }

        return list == list.reversed()
    }
}
