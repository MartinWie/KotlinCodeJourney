import org.junit.Test
import kotlin.test.assertTrue

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

    @Test
    fun test() {
        assertTrue { true }
    }

    class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }
}
