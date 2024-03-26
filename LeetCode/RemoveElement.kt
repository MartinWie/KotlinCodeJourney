import org.junit.Test
import kotlin.test.assertEquals

class RemoveElement {
    fun solve1(nums: IntArray, `val`: Int): Int {
        var i = 0
        for (j in 0..nums.lastIndex) {
            if (nums[j] != `val`) {
                nums[i] = nums[j]
                i++
            }
        }

        return i
    }

    fun solve2(nums: IntArray, `val`: Int): Int {
        var counter = 0
        nums.filter { it != `val` }.forEachIndexed { index, value ->
            nums[index] = value
            counter++
        }

        return counter
    }

    @Test
    fun test() {
        assertEquals(5, solve1(intArrayOf(0, 1, 2, 2, 3, 0, 4, 2), 2))
    }
}