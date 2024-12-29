package leetcode

import kotlin.math.max

class MaximumDepthBinaryTree_104 {
    class TreeNode {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        // 각 포인터마다 왼쪽 오른쪽 모두 탐색하며 Max Depth를 리턴해야한다.
        // 루트부터 시작하고, 내려간 노드에서 또 왼쪽 오른쪽 모두 탐색하는 Recursive
        val maxLeft = maxDepth(root.left)
        val maxRight = maxDepth(root.right)
        return max(maxLeft, maxRight) + 1
    }
}