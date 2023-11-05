class MaximumDepthOfBinaryTree {

    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val rightNumber = 1 + maxDepth(root.right)
        val leftNumber = 1 + maxDepth(root.left)

        return if (rightNumber >= leftNumber) rightNumber else leftNumber
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
