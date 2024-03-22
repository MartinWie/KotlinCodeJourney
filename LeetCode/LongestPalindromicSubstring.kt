import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class LongestPalindromicSubstring {
    private fun solve(s: String): String {
        if (s.length == 1) return s

        var currentLongestPalindrome = ""

        for (i in 0..s.lastIndex) {
            for (j in i..s.lastIndex) {
                val current = s.substring(i, j)
                if (isPalindrom(current) && current.length > currentLongestPalindrome.length) {
                    currentLongestPalindrome = current
                }
            }
            if (s.lastIndex - i <= currentLongestPalindrome.length) {
                break
            }
        }
        return currentLongestPalindrome
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
        assertEquals("bb", solve("bb"))
        assertEquals("bab", solve("babad"))
        assertEquals("bb", solve("cbbd"))
        assertEquals("a", solve("a"))
    }

    @Test
    fun `Test helper function isPalindrom`() {
        assertTrue { isPalindrom("aba") }
        assertTrue { isPalindrom("a") }
        assertTrue { isPalindrom("abba") }
        assertFalse { isPalindrom("abbac") }
    }
}