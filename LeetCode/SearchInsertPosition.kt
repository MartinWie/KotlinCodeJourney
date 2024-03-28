import org.junit.Test
import kotlin.test.assertEquals

class SearchInsertPosition {
    private fun solve1(nums: IntArray, target: Int): Int {
        var leftPointer = 0
        var rightPoiter = nums.lastIndex

        while (leftPointer < rightPoiter) {
            val middlePointer = (leftPointer + rightPoiter) / 2
            when {
                nums[middlePointer] == target -> return middlePointer
                nums[middlePointer] < target -> leftPointer = middlePointer + 1
                nums[middlePointer] > target -> rightPoiter = middlePointer - 1
            }
        }

        return leftPointer + 1
    }

    @Test
    fun `Test solve1`() {
        assertEquals(2, solve1(nums = intArrayOf(1, 3, 5, 6), 5))
        assertEquals(2, solve1(nums = intArrayOf(1, 3, 4, 5, 6), target = 4))
        assertEquals(1, solve1(nums = intArrayOf(1, 3, 5, 6), target = 2))
        assertEquals(4, solve1(nums = intArrayOf(1, 3, 5, 6), target = 7))
        assertEquals(0, solve1(nums = intArrayOf(1, 3, 5, 6), target = 0))
    }
}