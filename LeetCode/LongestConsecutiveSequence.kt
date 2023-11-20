import org.junit.Test
import kotlin.test.assertEquals

class LongestConsecutiveSequence {
    private fun longestConsecutive(nums: IntArray): Int {
        val numsSorted = nums.toSortedSet()
        var overallHighestCons = 0
        var currentHighestCons = if (nums.isEmpty()) 0 else 1
        var lastNum: Int? = null
        for (num in numsSorted) {
            if (lastNum != null && lastNum + 1 == num) {
                currentHighestCons++
            } else {
                currentHighestCons = 1
            }
            lastNum = num
            if (currentHighestCons > overallHighestCons) overallHighestCons = currentHighestCons
        }
        return overallHighestCons
    }

    private fun longestConsecutive2(nums: IntArray): Int {
        if (nums.isEmpty()) return 0
        if (nums.size == 1) return 1

        val numsHashSet = nums.toHashSet()
        var maxStreak = 1

        for (num in numsHashSet) {
            if (!numsHashSet.contains(num-1)) {
                var currentStreak = 1
                var currentNum = num + 1

                while (numsHashSet.contains(currentNum)) {
                    currentStreak++
                    currentNum++
                }

                maxStreak = maxOf(maxStreak, currentStreak)
            }
        }
        return maxStreak
    }

    @Test
    fun testLongestConsecutive() {
        assertEquals(4, longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
        assertEquals(9, longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
        assertEquals(0, longestConsecutive(intArrayOf()))
        assertEquals(7, longestConsecutive(intArrayOf(9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6)))
    }
}
