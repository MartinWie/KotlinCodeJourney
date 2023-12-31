import org.junit.Test
import kotlin.test.assertEquals

class MergeTwoSortedLists {
    private fun mergeTwoLists(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
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
            firstNode =
                if (firstNode == null) {
                    tmpNode
                } else {
                    appendNodeToEndOfList(firstNode, tmpNode)
                }
        }

        return firstNode
    }

    private fun appendNodeToEndOfList(
        head: ListNode?,
        append: ListNode,
    ): ListNode {
        append.next = null
        if (head == null) return append

        head.next =
            if (head.next == null) {
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

    private fun mergeTwoLists2(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val placeholderNode = ListNode(0)
        var currentLastNode = placeholderNode
        var list1Pointer = list1
        var list2Pointer = list2

        while (list1Pointer != null || list2Pointer != null) {
            when {
                (list1Pointer == null) -> {
                    currentLastNode.next = list2Pointer
                    break
                }
                (list2Pointer == null) -> {
                    currentLastNode.next = list1Pointer
                    break
                }
                (list1Pointer.`val` <= list2Pointer.`val`) -> {
                    currentLastNode.next = list1Pointer
                    list1Pointer = list1Pointer.next
                }
                else -> {
                    currentLastNode.next = list2Pointer
                    list2Pointer = list2Pointer.next
                }
            }
            currentLastNode = currentLastNode.next!!
        }
        return placeholderNode.next
    }

    @Test
    fun testMerge2() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(10)
        val a5 = ListNode(11)
        val b1 = ListNode(9)
        val b2 = ListNode(2)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        b2.next = b1
        val solutionNodes = mergeTwoLists2(a1, b2)
        val solutionList = nodesToList(solutionNodes)

        a1.next = a2
        a2.next = b2
        b2.next = a3
        a3.next = b1
        b1.next = a4
        a4.next = a5
        val expectedList = nodesToList(a1)

        assertEquals(expectedList.toString(), solutionList.toString())
    }

    private fun mergeTwoLists3(
        list1: ListNode?,
        list2: ListNode?,
    ): ListNode? {
        val dummyHead = ListNode(0)
        var currentList1 = list1
        var currentList2 = list2
        var currentTail = dummyHead

        while (currentList1 != null || currentList2 != null) {
            if (currentList1 == null) {
                currentTail.next = currentList2
                break
            } else if (currentList2 == null) {
                currentTail.next = currentList1
                break
            } else if (currentList1.`val` <= currentList2.`val`) {
                currentTail.next = currentList1
                currentList1 = currentList1.next
            } else {
                currentTail.next = currentList2
                currentList2 = currentList2.next
            }
            currentTail = currentTail.next!!
        }
        return dummyHead.next
    }

    @Test
    fun testMerge3() {
        val a1 = ListNode(1)
        val a2 = ListNode(2)
        val a3 = ListNode(3)
        val a4 = ListNode(10)
        val a5 = ListNode(11)
        val b1 = ListNode(9)
        val b2 = ListNode(2)

        a1.next = a2
        a2.next = a3
        a3.next = a4
        a4.next = a5
        b2.next = b1
        val solutionNodes = mergeTwoLists3(a1, b2)
        val solutionList = nodesToList(solutionNodes)

        a1.next = a2
        a2.next = b2
        b2.next = a3
        a3.next = b1
        b1.next = a4
        a4.next = a5
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
