import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        return head
    }

    @Test
    fun test() {
        val n1 = ListNode(1)
        val n2 = ListNode(2)
        n1.next = n2

        val solution = getValListFromNodes(reverseList(n1))

        n1.next = null
        n2.next = n1
        val shouldBe = getValListFromNodes(n2)

        assertEquals(shouldBe.toString(), solution.toString())
    }

    private fun getValListFromNodes(head: ListNode?): MutableList<Int> {
        val list = mutableListOf<Int>()
        var currentNode: ListNode? = head
        while (currentNode != null) {
            list.add(currentNode.`val`)
            currentNode = currentNode.next
        }

        return list
    }
}
