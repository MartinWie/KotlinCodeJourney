import org.junit.Test
import kotlin.test.assertEquals

class FindTheIndexOfTheFirstOccurrenceInAString {

    private fun solve(haystack: String, needle: String): Int {
        val pattern = needle.toRegex()
        return pattern.find(haystack)?.range?.first ?: return -1
    }

    @Test
    fun testSolve() {
        assertEquals(0, solve("sadbutsad", "sad"))
        assertEquals(-1, solve("leetcode", "leeto"))
    }
}