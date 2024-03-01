import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

/**
 * Example:
 * var li = ListNode(5)
 * var v = li.`val`
 * Definition for singly-linked list.
 * class ListNode(var `val`: Int) {
 *     var next: ListNode? = null
 * }
 */

class AddTwoNumbers {
    private fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        // TODO: implement
    }

    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    @Test
    fun helperFunctionTest() {
        val first = ListNode(1)
        val second = ListNode(0)
        val third = ListNode(1)
        second.next = third
        first.next = second

        val a = ListNode(1)
        val b = ListNode(0)
        val c = ListNode(1)

        b.next = c
        a.next = b

        assertTrue { first.same(a) }

        val z = ListNode(8)
        val y = ListNode(9)
        y.next = z

        val x = ListNode(0)
        val w = ListNode(9)

        w.next = x

        assertFalse { y.same(w) }
    }

    @Test
    fun test() {
        val result1 = ListNode(7)
        val result2 = ListNode(0)
        val result3 = ListNode(8)
        result1.next = result2
        result2.next = result3

        val a1 = ListNode(2)
        val a2 = ListNode(4)
        val a3 = ListNode(3)

        a2.next = a3
        a1.next = a2

        val b1 = ListNode(5)
        val b2 = ListNode(6)
        val b3 = ListNode(4)

        b2.next = b3
        b1.next = b2

        assertTrue { result1.same(addTwoNumbers(a1, b1)) }
    }

    private fun ListNode.same(node: ListNode?): Boolean {
        if (node == null || this.`val` != node.`val`) return false

        if (this.next == null && node.next == null) return true

        return this.next?.same(node.next) ?: false
    }

}