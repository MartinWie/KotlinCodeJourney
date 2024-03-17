import org.junit.Test
import kotlin.test.assertEquals

class RemoveDuplicatesFromSortedArray {
    private fun solve(nums: IntArray): Int {
        var counter = 0
        var formerNum = nums.first() + 1
        for (i in 0..nums.lastIndex) {
            if (nums[i] == formerNum) {
                nums.removeAt(i)
                counter++
            }
        }

        return nums.size
    }

    private fun IntArray.removeAt(index: Int) {
        for (i in index until this.lastIndex) {
            this[i] = this[i + 1]
        }
        this[this.lastIndex] = 0
    }

    @Test
    fun testIntArrayExtensionFunction() {
        val arr = intArrayOf(1, 2, 3, 4)
        arr.removeAt(0)
        arr.removeAt(0)

        assertEquals(3, arr.first())
    }
}