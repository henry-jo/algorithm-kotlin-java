package datastructure

class SimpleLinkedList(
    var head: Node = Node(data = null), // haed는 데이터가 저장되는 곳이 아닌 노드를 탐색하기 위한 포인터 역할
    var size: Int = 0
) {

    data class Node(
        var data: Int?,
        var nextNode: Node? = null
    )

    fun getNode(index: Int): Node {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index : $index, Size : $size")
        }

        var node = head.nextNode!!

        for (i in 0 until index) {
            node = node.nextNode!!
        }

        return node
    }

    fun getData(index: Int): Int { // index 위치에 있는 데이터를 반환
        return getNode(index).data!!
    }

    fun getFirst(): Int { // 첫번째 데이터를 반환
        return getData(0)
    }

    fun getNodeIndex(data: Int): Int { // 해당 데이터 index 위치를 반환
        if (size <= 0) {
            return -1
        }

        var node = head.nextNode
        var index = 0

        while (node != null) {
            if (data == node.data) {
                return index
            }

            node = node.nextNode
            index++
        }

        return -1 // 해당 데이터가 존재하지 않으면 -1 리턴
    }

    // 첫번째 위치에 노드 삽입
    fun addFirst(data: Int): Boolean {
        val newNode = Node(data = data, nextNode = head.nextNode)
        head.nextNode = newNode

        size++

        return true
    }

    // 원하는 위치에 노드 삽입
    fun add(index: Int, data: Int): Boolean {
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index : $index, Size : $size")
        }

        if (index == 0) {
            addFirst(data)
        }

        val newNode = Node(data)

        val prevNode = getNode(index - 1)
        val nextNode = prevNode.nextNode

        prevNode.nextNode = newNode
        newNode.nextNode = nextNode

        size++

        return true
    }

    fun removeFirst(): Int { // 첫번째 노드를 삭제하고 데이터를 반환
        val firstNode = getNode(0)
        head.nextNode = firstNode.nextNode

        size--

        return firstNode.data!!
    }

    fun remove(index: Int): Any { // index에 해당하는 노드를 제거하고 데이터를 반환
        if (index < 0 || index >= size) {
            throw IndexOutOfBoundsException("Index : $index, Size : $size")
        }

        if (index == 0) {
            return removeFirst()
        }

        val prevNode = getNode(index - 1)
        val delNode = getNode(index)

        prevNode.nextNode = delNode.nextNode

        size--

        return delNode.data!!
    }

    fun reverse() {
        var nextNode = head.nextNode
        var curNode: Node? = null
        var prevNode: Node? = null

        while (nextNode != null) {
            prevNode = curNode
            curNode = nextNode
            nextNode = nextNode.nextNode
            curNode.nextNode = prevNode
        }

        head.nextNode = curNode
    }
}