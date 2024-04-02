import org.junit.Test
import java.util.*
import kotlin.test.assertEquals

class AddBinary {
    private fun solve(a: String, b: String): String {
        var result = ""
        var carryOver = false

        val aStack = Stack<Char>()
        val bStack = Stack<Char>()

        a.forEach { aStack.add(it) }
        b.forEach { bStack.add(it) }

        while (aStack.isNotEmpty() || bStack.isNotEmpty()) {
            val aTemp = if (aStack.isNotEmpty()) aStack.pop() else '0'
            val bTemp = if (bStack.isNotEmpty()) bStack.pop() else '0'

            when {
                aTemp == '1' && bTemp == '1' && carryOver -> {
                    result = result.plus("1")
                }

                aTemp == '1' && bTemp == '1' && !carryOver -> {
                    carryOver = true
                    result = result.plus("0")
                }


                aTemp == '0' && bTemp == '1' && carryOver -> {
                    result = result.plus("0")
                }

                aTemp == '1' && bTemp == '0' && !carryOver -> {
                    result = result.plus("1")
                }

                aTemp == '1' && bTemp == '0' && carryOver -> {
                    result = result.plus("0")
                }

                aTemp == '0' && bTemp == '1' && !carryOver -> {
                    result = result.plus("1")
                }

                aTemp == '0' && bTemp == '0' && carryOver -> {
                    carryOver = false
                    result = result.plus("1")
                }

                aTemp == '0' && bTemp == '0' && !carryOver -> {
                    result = result.plus("0")
                }
            }
        }

        if (carryOver) result = result.plus("1")

        return result.reversed()
    }

    @Test
    fun testSolve() {
        assertEquals("100", solve("001", "011"))
        assertEquals("111", solve("001", "110"))
        assertEquals("1000", solve("111", "001"))
    }

    private fun solve2(a: String, b: String): String {
        // TODO: implement BigInt conversion solution
    }

    @Test
    fun testSolve2() {
        assertEquals("100", solve2("001", "011"))
        assertEquals("111", solve2("001", "110"))
        assertEquals("1000", solve2("111", "001"))
    }
}