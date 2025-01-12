package leetcode

class IntersectionTwoLinkedList_160 {
    class ListNode(var value: Int) {
        var next: ListNode? = null
    }

    fun getIntersectionNode(headA: ListNode?, headB: ListNode?): ListNode? {
        val set = hashSetOf<ListNode>()
        var curA = headA
        while(curA != null) {
            set.add(curA)
            curA = curA.next
        }
        var curB = headB
        while(curB != null) {
            if (set.contains(curB)) return curB
            curB = curB.next
        }

        return null

        // 이 방법은 이해는 가지만 (1에서는 왜 contains가 아닌지는 모르겠음)
        // 리스트 두개를 이어 붙여서 순회하는건 이해가 안된다..
    }
}
