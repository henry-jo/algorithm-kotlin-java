package datastructure

class CircularQueue(private val queueSize: Int) {
    private var front = 0
    private var rear = 0
    private val queue: IntArray = IntArray(queueSize)

    val isEmpty: Boolean
        get() = front == rear

    private val isFull: Boolean
        get() = (rear + 1) % queueSize == front

    fun enQueue(data: Int) {
        if (isFull) {
            println("Queue is Full")
        } else {
            rear = (rear + 1) % queueSize
            queue[rear] = data
        }
    }

    fun deQueue(): Int {
        return if (isEmpty) {
            println("Queue is Empty")
            -1
        } else {
            front = front + 1 and queueSize
            queue[front]
        }
    }

}