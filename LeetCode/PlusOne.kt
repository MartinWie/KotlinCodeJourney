import org.junit.Test
import kotlin.test.assertEquals

class PlusOne {
    private fun solve(digits: IntArray): IntArray {
        var currentPosition = digits.lastIndex

        while (currentPosition >= 0 && digits[currentPosition] == 9) {
            digits[currentPosition] = 0
            currentPosition--
        }

        return if (currentPosition < 0) {
            intArrayOf(1) + digits
        } else {
            digits[currentPosition] = digits[currentPosition] + 1
            digits
        }
    }

    @Test
    fun testSolve() {
        assertEquals(intArrayOf(5, 0, 1).contentToString(), solve(intArrayOf(5, 0, 0)).contentToString())
        assertEquals(intArrayOf(1, 0, 0).contentToString(), solve(intArrayOf(9, 9)).contentToString())
        assertEquals(intArrayOf(1).contentToString(), solve(intArrayOf(0)).contentToString())
    }
}