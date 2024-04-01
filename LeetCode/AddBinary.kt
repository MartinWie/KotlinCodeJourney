import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class AddBinary {
    private fun solve(a: String, b: String): String {
        var result = ""
        var carryOver = 0

        val aStack = Stack<Char>()
        val bStack = Stack<Char>()

        a.forEach { aStack.add(it) }
        b.forEach { bStack.add(it) }

        while (a.isNotEmpty() || b.isNotEmpty()) {
            val aTemp = aStack.pop()
            val bTemp = bStack.pop()

            when {
                aTemp == '1' && bTemp == '1' -> {}
                // TODO: think about this and then implement efficient solution
            }
        }

        return result.reversed()
    }

    @Test
    fun testSolve() {
        assertEquals("100", solve("001", "011"))
        assertEquals("111", solve("001", "110"))
        assertEquals("1000", solve("111", "001"))
    }
}