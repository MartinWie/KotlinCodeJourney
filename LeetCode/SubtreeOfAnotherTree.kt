class SubtreeOfAnotherTree {
    fun isSubtree(root: TreeNode?, subRoot: TreeNode?): Boolean {
        if (root == null && subRoot == null) return true
        if (root == null || subRoot == null) return false
        if (root.`val` == subRoot.`val`) {
            return isSubtree(root.left, subRoot.left) && isSubtree(root.right, subRoot.right)
        }
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot)
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
