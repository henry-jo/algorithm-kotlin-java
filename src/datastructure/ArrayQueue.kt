package datastructure

class ArrayQueue(private var size: Int) {
    private var queue = intArrayOf()
    private var front = 0
    private var rear = 0

    init {
        queue = IntArray(size)
        front = -1
        rear = -1
    }

    fun enQueue(value: Int) {
        if (isFull()) { // 큐 포화상태 검사
            println("Queue is FULL !!")
        } else {
            queue[++rear] = value
            println("enqueue : " + queue[rear])
        }
    }

    fun deQueue(): Int {
        return if (isEmpty()) { // 큐 공백 검사
            println("Queue is EMPTY !!")
            -1
        } else {
            println("dequeue : " + queue[++front])
            queue[front]
        }
    }

    private fun isFull(): Boolean {
        return rear == size - 1
    }

    fun isEmpty(): Boolean {
        return front == rear
    }

    fun printQueue() {
        println("--- QUEUE LIST ---")
        for (i in front + 1..rear) {
            println(queue[i])
        }
    }
}