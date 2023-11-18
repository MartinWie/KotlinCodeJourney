import java.util.Stack

class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false

        val searchStack = Stack<TreeNode>()
        searchStack.add(root)

        while (searchStack.isNotEmpty()) {
            val currentNode = searchStack.pop()
            val left = currentNode.left
            val right = currentNode.right

            if (currentNode.`val` == subRoot.`val` &&
                isSameTree(left, subRoot.left) &&
                isSameTree(right, subRoot.right)
            ) {
                return true
            }

            if (left != null) searchStack.add(left)
            if (right != null) searchStack.add(right)
        }

        return false
    }

    private fun isSameTree(tree1: TreeNode?, tree2: TreeNode?): Boolean {
        if (tree1 == null && tree2 == null) return true
        if (tree1 == null || tree2 == null) return false

        if (tree1.`val` == tree2.`val`) {
            return isSameTree(tree1.left, tree2.left) && isSameTree(tree1.right, tree2.right)
        }
        return false
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
