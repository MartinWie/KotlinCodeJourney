import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeNumber {

    private fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val mirrored = x.toString().reversed().toLong()
        return (x - mirrored).toInt() == 0
    }

    private fun isPalindrome2(x: Int): Boolean {
        if (x < 0 || x % 10 == 0 && x != 0) return false
        return (x - x.toString().reversed().toLong()).toInt() == 0
    }

    private fun isPalindrome3(x: Int): Boolean {
        if (x < 0 || x % 10 == 0 && x != 0) return false
        val xStr = x.toString()
        for (i in 0..xStr.length / 2) {
            if (xStr[i] != xStr[xStr.lastIndex - i]) return false
        }

        return true
    }

    @Test
    fun test() {
        assertTrue { isPalindrome(101) }
        assertTrue { isPalindrome(121) }
        assertFalse { isPalindrome(-101) }
    }

    @Test
    fun test2() {
        assertTrue { isPalindrome2(101) }
        assertTrue { isPalindrome2(121) }
        assertFalse { isPalindrome2(-101) }
    }

    @Test
    fun test3() {
        assertTrue { isPalindrome3(101) }
        assertTrue { isPalindrome3(121) }
        assertFalse { isPalindrome3(-101) }
    }
}