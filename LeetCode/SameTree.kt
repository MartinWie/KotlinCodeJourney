import java.util.Stack

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

    fun isSameTree2(p: TreeNode?, q: TreeNode?): Boolean {
        val pStack = Stack<TreeNode?>()
        val qStack = Stack<TreeNode?>()

        pStack.add(p)
        qStack.add(q)

        while (!pStack.isEmpty()) {
            val currentP = pStack.pop()
            val currentQ = qStack.pop()

            if (currentP?.`val` != currentQ?.`val`) return false

            if (currentP != null) {
                pStack.add(currentP.left)
                pStack.add(currentP.right)
            }
            if (currentQ != null) {
                qStack.add(currentQ.left)
                qStack.add(currentQ.right)
            }
        }

        return qStack.isEmpty()
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
