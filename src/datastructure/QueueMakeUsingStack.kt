package datastructure

import java.util.*


/**
 * 스택을 이용해서 큐 구현하기
 */
class QueueMakeUsingStack {
    private val inBox = Stack<Int>()
    private val outBox = Stack<Int>()

    fun enQueue(data: Int) {
        inBox.add(data)
    }

    fun deQueue(): Int {
        if (outBox.isEmpty()) {
            while (!inBox.isEmpty()) {
                outBox.push(inBox.pop())
            }
        }
        return outBox.pop() as Int
    }
}