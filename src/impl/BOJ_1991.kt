package impl

/**
 * Binary Tree를 HashMap을 이용하여 구현 및 탐색
 */
class BOJ_1991 {
    fun solve() {
        val n = readLine()!!.toInt()
        val binaryTree = hashMapOf<String, BinaryTree>()

        repeat(n) {
            val (key, left, right) = readLine()!!.split(" ")
            binaryTree[key] = BinaryTree(left, right)
        }

        preorder("A", binaryTree)
        println()
        inorder("A", binaryTree)
        println()
        postorder("A", binaryTree)
    }

    private data class BinaryTree (
        val leftNode: String? = null,
        val rightNode: String? = null
    )

    private fun preorder(key: String?, binaryTreeMap: HashMap<String, BinaryTree>) {
        val binaryTree = binaryTreeMap[key]

        if (key != null && binaryTree != null) {
            print(key)
            preorder(binaryTree.leftNode, binaryTreeMap)
            preorder(binaryTree.rightNode, binaryTreeMap)
        }
    }

    private fun inorder(key: String?, binaryTreeMap: HashMap<String, BinaryTree>) {
        val binaryTree = binaryTreeMap[key]

        if (key != null && binaryTree != null) {
            inorder(binaryTree.leftNode, binaryTreeMap)
            print(key)
            inorder(binaryTree.rightNode, binaryTreeMap)
        }
    }

    private fun postorder(key: String?, binaryTreeMap: HashMap<String, BinaryTree>) {
        val binaryTree = binaryTreeMap[key]

        if (key != null && binaryTree != null) {
            postorder(binaryTree.leftNode, binaryTreeMap)
            postorder(binaryTree.rightNode, binaryTreeMap)
            print(key)
        }
    }
}

fun main(args: Array<String>) {
    BOJ_1991().solve()
}