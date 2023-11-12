import kotlin.math.abs

class BalancedBinaryTree {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) return true

        val lMaxDepth = maxDepth(root.left)
        val rMaxDepth = maxDepth(root.right)

        return (lMaxDepth - rMaxDepth) in listOf(-1, 0, 1)
    }

    private fun maxDepth(node: TreeNode?): Int {
        if (node == null) return 0

        val left = 1 + maxDepth(node.left)
        val right = 1 + maxDepth(node.right)

        return maxOf(left, right)
    }

    fun isBalance2(root: TreeNode?): Boolean {
        if (root == null) return true
        return balancedHelper(root) != -1
    }

    private fun balancedHelper(node: TreeNode?): Int {
        node ?: return 0

        val lDepth = balancedHelper(node.left)
        if (lDepth == -1) return -1

        val rDepth = balancedHelper(node.right)
        if (rDepth == -1) return -1

        return if (abs(lDepth - rDepth) <= 1) {
            maxOf(lDepth, rDepth) + 1
        } else {
            -1
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
