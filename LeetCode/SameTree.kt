class SameTree {
    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        val pList = treeToList(p)
        val qList = treeToList(q)
        return pList == qList
    }

    private fun treeToList(node: TreeNode?): List<Int?> {
        node ?: return listOf<Int?>(null)

        val lList = treeToList(node.left)
        val rList = treeToList(node.right)

        return listOf(node.`val`) + lList + rList
    }

    // TODO: implement a solution where both trees are compared node by node

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
