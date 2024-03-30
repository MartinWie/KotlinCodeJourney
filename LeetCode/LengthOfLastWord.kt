import org.junit.Test
import kotlin.test.assertEquals

class LengthOfLastWord {
    private fun solve(s: String): Int {
        return s.trim().split(' ').last().length
    }

    @Test
    fun testSolve() {
        assertEquals(5, solve("Hallo tests"))
        assertEquals(4, solve("   fly me   to   the moon  "))
    }
}