import kotlin.test.Test
import kotlin.test.assertEquals

class ReverseLinkedList {
    class ListNode(var `val`: Int) {
        var next: ListNode? = null
    }

    fun reverseList(head: ListNode?): ListNode? {
        if (head == null) return null

        val nodeList = mutableListOf<ListNode>()
        var currentNode = head

        while (currentNode != null) {
            nodeList.add(currentNode)
            currentNode = currentNode.next
        }

        var tail: ListNode? = null

        nodeList.forEach {
            it.next = tail
            tail = it
        }

        return tail
    }

    fun reverseList2(head: ListNode?): ListNode? {
        val currntNode = head

        while (currntNode != null) {

        }

    }

    fun reverseList3(head: ListNode?): ListNode? {
        val currntNode = head

        while (currntNode != null) {

        }

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
    @Test
    fun test2() {
        val n1 = ListNode(1)
        val n2 = ListNode(2)
        n1.next = n2

        val solution = getValListFromNodes(reverseList2(n1))

        n1.next = null
        n2.next = n1
        val shouldBe = getValListFromNodes(n2)

        assertEquals(shouldBe.toString(), solution.toString())
    }

    @Test
    fun test3() {
        val n1 = ListNode(1)
        val n2 = ListNode(2)
        n1.next = n2

        val solution = getValListFromNodes(reverseList3(n1))

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
