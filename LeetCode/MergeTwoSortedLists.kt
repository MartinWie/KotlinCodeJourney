import org.junit.Test
import kotlin.test.assertEquals

class MergeTwoSortedLists {
    private fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
        val mergedList = mutableListOf<Int>()
        var list1Pointer = list1
        var list2Pointer = list2
        while (list1Pointer != null || list2Pointer != null) {
            if (list1Pointer == null) {
                mergedList.add(list2Pointer!!.`val`)
                list2Pointer = list2Pointer.next
                continue
            }

            if (list2Pointer == null) {
                mergedList.add(list1Pointer.`val`)
                list1Pointer = list1Pointer.next
                continue
            }

            if (list1Pointer.`val` <= list2Pointer.`val`) {
                mergedList.add(list1Pointer.`val`)
                list1Pointer = list1Pointer.next
            } else {
                mergedList.add(list2Pointer.`val`)
                list2Pointer = list2Pointer.next
            }
        }

        var firstNode: ListNode? = null
        mergedList.forEach {
            val tmpNode = ListNode(it)
            firstNode = if (firstNode == null) {
                tmpNode
            } else {
                appendNodeToEndOfList(firstNode, tmpNode)
            }
        }

        return firstNode
    }

    private fun appendNodeToEndOfList(head: ListNode?, append: ListNode): ListNode? {
        append.next = null
        if (head == null) return append

        head.next = if (head.next == null) {
            append
        } else {
            appendNodeToEndOfList(head.next, append)
        }

        return head
    }

    @Test
    fun testMerge() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val b1 = ListNode(9)
        val b2 = ListNode(2)

        a1.next = a2
        b2.next = b1
        val solutionNodes = mergeTwoLists(a1, b2)
        val solutionList = nodesToList(solutionNodes)

        a2.next = b2
        val expectedList = nodesToList(a1)

        assertEquals(expectedList.toString(), solutionList.toString())
    }

    private fun nodesToList(head: ListNode?): List<Int> {
        val list = mutableListOf<Int>()
        var currentNode = head
        while (currentNode != null) {
            list.add(currentNode.`val`)
            currentNode = currentNode.next
        }
        return list
    }
}

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}
