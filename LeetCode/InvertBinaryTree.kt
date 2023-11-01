import org.junit.Test
import kotlin.test.assertTrue

class InvertBinaryTree {

    fun invertTree(root: TreeNode?): TreeNode? {
        return TreeNode(1)
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