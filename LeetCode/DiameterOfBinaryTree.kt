import java.util.Stack

class DiameterOfBinaryTree {
    fun diameterOfBinaryTree(root: TreeNode?): Int {
        if (root == null) return 0

        var currentMaxDiameterLeftBranch = 0
        var currentMaxDiameterRightBranch = 0
        val stack = Stack<Triple<TreeNode, Int, Int>>()

        stack.push(Triple(root, currentMaxDiameterLeftBranch, currentMaxDiameterRightBranch))

        while (stack.isNotEmpty()) {
            val (currentNode, left, right) = stack.pop()

            if (currentNode.left != null) {
                currentMaxDiameterLeftBranch = left + 1
                stack.push(Triple(currentNode.left!!, left + 1, right))
            }

            if (currentNode.right != null) {
                currentMaxDiameterRightBranch = right + 1
                stack.push(Triple(currentNode.right!!, left, right + 1))
            }
        }

        return currentMaxDiameterLeftBranch + currentMaxDiameterRightBranch
    }
}

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}
