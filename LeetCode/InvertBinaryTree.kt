class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) return null

        val tmpNode: TreeNode? = root.right

        root.right = root.left
        root.left = tmpNode

        invertTree(root.left)
        invertTree(root.right)

        return root
    }

    fun invertTree2(root: TreeNode?): TreeNode? {
        return root?.apply {
            val tmp = this.left
            this.left = right
            this.right = tmp
            invertTree2(left)
            invertTree2(right)
        }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
