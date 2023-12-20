import java.util.Stack

class MaximumDepthOfBinaryTree {
    fun maxDepth(root: TreeNode?): Int {
        if (root == null) return 0

        val rightNumber = 1 + maxDepth(root.right)
        val leftNumber = 1 + maxDepth(root.left)

        return if (rightNumber >= leftNumber) rightNumber else leftNumber
    }

    fun maxDepth2(root: TreeNode?): Int {
        if (root == null) return 0

        val stack = Stack<Pair<TreeNode, Int>>()
        var currentMaxDepth = 1

        stack.push(Pair(root, currentMaxDepth))

        while (stack.isNotEmpty()) {
            val (node, depth) = stack.pop()
            currentMaxDepth = maxOf(currentMaxDepth, depth)

            node.right?.let { stack.push(Pair(it, depth + 1)) }
            node.left?.let { stack.push(Pair(it, depth + 1)) }
        }

        return currentMaxDepth
    }

    fun maxDepth3(root: TreeNode?): Int {
        if (root == null) return 0

        val lDepth = 1 + maxDepth3(root.left)
        val rDepth = 1 + maxDepth3(root.right)

        return maxOf(lDepth, rDepth)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
