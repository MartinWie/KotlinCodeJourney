import org.junit.Test
import kotlin.test.assertEquals

class FindTheIndexOfTheFirstOccurrenceInAString {

    private fun solve(haystack: String, needle: String): Int {
        val pattern = needle.toRegex()
        return pattern.find(haystack)?.range?.first ?: return -1
    }

    private fun solve2(haystack: String, needle: String): Int {
        if (needle.length == 1 && haystack.first() == needle.first()) return 0
        for (i in 0..haystack.lastIndex - needle.lastIndex) {
            if (haystack.substring(i, (i + needle.length)) == needle) return i
        }
        return -1
    }

    @Test
    fun testSolve() {
        assertEquals(0, solve("sadbutsad", "sad"))
        assertEquals(-1, solve("leetcode", "leeto"))
        assertEquals(0, solve("a", "a"))
    }

    @Test
    fun testSolve2() {
        assertEquals(0, solve2("sadbutsad", "sad"))
        assertEquals(-1, solve2("leetcode", "leeto"))
        assertEquals(0, solve2("a", "a"))
        assertEquals(2, solve2("abc", "c"))
    }
}