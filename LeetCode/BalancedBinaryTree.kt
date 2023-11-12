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

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
