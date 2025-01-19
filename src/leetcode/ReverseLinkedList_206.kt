package leetcode

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 **/
 class ListNode(var value: Int) {
      var next: ListNode? = null
 }

class ReverseLinkedList_206 {
    fun reverseList(head: ListNode?): ListNode? {
        var prevNode: ListNode? = null
        var curNode: ListNode? = head

        while (curNode != null) {
            val nextNode = curNode.next

            curNode.next = prevNode
            prevNode = curNode

            curNode = nextNode
        }

        return prevNode
    }
}

fun main() {
    val head = ListNode(1).apply { next = ListNode(2).apply { next = ListNode(3) } }
    println(ReverseLinkedList_206().reverseList(head))
}
