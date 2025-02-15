package leetcode

/**
 * Example:
 * var ti = TreeNode(5)
 * var v = ti.`val`
 * Definition for a binary tree node.
 **/

class InvertBinaryTree_226 {
    data class TreeNode(var value: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val left = invertTree(root.left)
        val right = invertTree(root.right)

        root.left = right
        root.right = left

        return root
    }
}
