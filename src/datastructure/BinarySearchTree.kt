package datastructure

/**
 * Created by ByeongChan on 2017. 11. 7..
 *
 * 이진 탐색 트리 구현 (Java)
 */

data class Node(
    var data: Int,
    var left: Node? = null,
    var right: Node? = null
)

class BinarySearchTree {

    var root: Node? = null

    // 탐색연산
    fun searchKey(key: Int): Boolean {
        var cur = root // 루트부터 탐색

        while (cur != null) {
            cur = when {
                cur.data == key -> // 탐색 키 값과 같다면 true 리턴
                    return true
                cur.data > key -> // 탐색키가 작으면 왼쪽 서브트리로 이동
                    cur.left
                else -> // 탐색키가 크면 오른쪽 서브트리로 이동
                    cur.right
            }
        }

        // 탐색을 다 마쳤는데 찾지 못하면 false 리턴
        return false
    }

    // 삽입연산
    fun insertKey(key: Int) {
        val newNode = Node(key) // 삽입될 키를 노드로 생성
        // 이제 알맞은 위치를 찾아 이 노드를 삽입해주면 된다.

        root ?: run {
            // 만약 루트가 없다면 이 노드가 루트가 된다.
            root = newNode
            return
        }

        var cur = root // 탐색할 노드. 탐색은 루트부터 시작
        var parent: Node? // 이 노드 자식 노드로 삽입될 것임

        while (true) {
            parent = cur // 부모 노드를 현재 노드로 설정하고 cur노드는 탐색을 진행

            when {
                cur!!.data < key -> { // key 값이 크다면
                    cur = cur.right // 오른쪽 서브트리로 이동

                    cur ?: run {
                        // 오른쪽 서브트리가 null이라면 오른쪽 서브트리에 삽입
                        parent!!.right = newNode
                        return
                    }
                }
                cur.data > key -> { // key 값이 작다면
                    cur = cur.left // 왼쪽 서브트리로 이동

                    cur ?: run {
                        parent!!.left = newNode
                        return
                    }
                }
                else -> { // 만약 삽입하려던 key와 값다면 삽입이 되면 안된다. 이진탐색트리엔 중복된 key값이 존재하지 않는다.
                    return
                }
            }
        }
    }

    // 삭제연산
    fun deleteKey(key: Int): Boolean {
        var cur = root
        var parent: Node? = null // 삽입삭제와 마찬가지로 삭제 시에 부모 노드에서 연결을 끊어주어야 한다.
        var isLeftChild = false // 삭제할 노드가 부모노드의 왼쪽노드인지 아닌지를 확인해줄 변수

        while (cur!!.data != key) {
            parent = cur

            if (cur.data > key) {
                isLeftChild = true // 현재 노드의 왼쪽 노드이므로
                cur = cur.left
            } else {
                isLeftChild = false // 오른쪽 노드로 이동한다면 false로 다시 변경
                cur = cur.right
            }

            if (cur == null) { // 키가 존재하지 않으면
                return false
            }
        }

        // Case 1 : 자식노드가 없는 단말 노드의 경우
        if (cur.left == null && cur.right == null) {
            if (cur === root) { // 루트 노드라면 이진탐색트리를 null
                root = null
            }

            if (isLeftChild) { // 삭제할 노드가 부모노드의 왼쪽 노드라면
                parent!!.left = null // 부모 노드의 왼쪽 노드를 삭제
            } else {
                parent!!.right = null
            }
        } else if (cur.right == null) { // 오른쪽 노드가 없는 경우
            if (cur === root) {
                root = cur.left // 왼쪽 노드를 루트로 변경
            }

            if (isLeftChild) { // 삭제할 노드가 부모노드의 왼쪽 노드라면
                parent!!.left = cur.left // 부모노드의 왼쪽 노드를 삭제할 노드의 왼쪽 노드로 대체
            } else {
                parent!!.right = cur.left
            }
        } else if (cur.left == null) {
            if (cur === root) {
                root = cur.right
            }

            if (isLeftChild) {
                parent!!.left = cur.right
            } else {
                parent!!.right = cur.right
            }
        } else if (cur.left != null && cur.right != null) {
            // 오른쪽 서브트리에서 최소값을 찾는 방법과
            // 왼쪽 서브트리에서 최대값을 찾는 방법 두 가지 방법이 존재한다.

            // 오른쪽 서브트리에서 최소값을 찾는 방법을 선택
            val rightMin = getRightMin(cur)

            if (cur === root) {
                root = rightMin
            }

            if (isLeftChild) {
                parent!!.left = rightMin
            } else {
                parent!!.right = rightMin
            }

            rightMin.left = cur.left // 왼쪽 서브트리 연결. 오른쪽 서브트리는 연결되어있음
        }// Case 3 : 두개의 자식 노드를 갖는 경우
        // Case 2 : 하나의 자식 노드를 갖는 경우

        return true
    }

    fun getRightMin(deleteNode: Node): Node {
        var cur = deleteNode.right
        var rightMinParent: Node? = null

        while (cur!!.left != null) {
            rightMinParent = cur
            cur = cur.left // 오른쪽 서브트리에서 제일 왼쪽에 있는 노드가 최소값이므로 탐색
        }

        if (cur !== deleteNode.right) { // 만약 오른쪽 서브트리 최소값이 삭제할 노드 오른쪽 자식이 아니라면
            rightMinParent!!.left = cur.right
            cur.right = deleteNode.right // 오른쪽 서브 트리를 연결
            // 왼쪽 서브트리도 연결시켜야하는데 이 함수에서 연결시키기 까다로움
            // 왼쪽 서브트리는 위에서 연결
        }

        return cur
    }

    // print method
    fun inorder(root: Node?) {
        if (root != null) {
            inorder(root.left)
            println(root.data)
            inorder(root.right)
        }
    }

    fun preorder(root: Node?) {
        if (root != null) {
            println(root.data)
            preorder(root.left)
            preorder(root.right)
        }
    }

    fun postorder(root: Node?) {
        if (root != null) {
            postorder(root.left)
            postorder(root.right)
            println(root.data)
        }
    }

    // print
    fun printBST() {
        inorder(root)
        println()
    }
}
