import org.junit.Test
import kotlin.test.assertFalse
import kotlin.test.assertTrue

class PalindromeNumber {

    private fun isPalindrome(x: Int): Boolean {
        if (x < 0) return false
        val mirrored = x.toString().reversed().toLong()
        return (x - mirrored).toInt() == 0
    }

    @Test
    fun test() {
        assertTrue { isPalindrome(101) }
        assertTrue { isPalindrome(121) }
        assertFalse { isPalindrome(-101) }
    }
}