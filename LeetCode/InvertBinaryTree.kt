import java.util.LinkedList

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

    fun invertTree3(root: TreeNode?): TreeNode? {
        val queue = LinkedList<TreeNode>()

        root?.let { queue.add(it) }

        while (queue.isNotEmpty()) {
            val current = queue.remove()

            val tmpNode = current.left
            current.left = current.right
            current.right = tmpNode

            if (current.left != null) queue.add(current.left!!)
            if (current.right != null) queue.add(current.right!!)
        }

        return root
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
