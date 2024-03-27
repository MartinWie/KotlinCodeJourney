import org.junit.Test
import kotlin.test.assertEquals

class SearchInsertPosition {
    private fun solve1(nums: IntArray, target: Int): Int {
        return nums.size
    }

    @Test
    fun `Test solve1`() {
        assertEquals(2, solve1(nums = intArrayOf(1, 3, 5, 6), 5))
    }
}