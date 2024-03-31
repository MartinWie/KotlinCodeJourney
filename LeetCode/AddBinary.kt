import org.junit.Test
import kotlin.test.assertEquals

class AddBinary {
    private fun solve(a: String, b: String): String {
        return ""
    }

    @Test
    fun testSolve() {
        assertEquals("100", solve("001", "011"))
        assertEquals("111", solve("001", "110"))
        assertEquals("1000", solve("111", "001"))
    }
}