import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LongestPalindromicSubstring {
    private fun solve(s: String): String {
        var currentLongestPalindrome = ""
        var currentPointer = 0
        var tmpPalindrome = ""
        for (i in 0..s.lastIndex) {
            // TODO: finish implementation of solve
            if (s.lastIndex - i <= currentLongestPalindrome.length) break
        }
        return "TBD"
    }

    private fun isPalindrom(s: String): Boolean {
        var leftPointer = 0
        var rightPointer = s.lastIndex

        while (leftPointer < rightPointer) {
            if (s[leftPointer] != s[rightPointer]) return false
            leftPointer++
            rightPointer--
        }

        return true
    }

    @Test
    fun `Test solve`() {
        assertEquals("bab", solve("babad"))
        assertEquals("bb", solve("cbbd"))
    }

    @Test
    fun `Test helper function isPalindrom`() {
        assertTrue { isPalindrom("aba") }
        assertTrue { isPalindrom("a") }
        assertTrue { isPalindrom("abba") }
        assertFalse { isPalindrom("abbac") }
    }
}