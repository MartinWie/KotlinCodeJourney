import org.junit.Test
import kotlin.test.assertEquals

class RemoveElement {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        return nums.size
    }

    @Test
    fun test() {
        assertEquals(5, removeElement(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    }
}