import org.junit.Test
import kotlin.test.assertEquals

class RomanToInteger {
    private fun romanToInt(s: String): Int {
        val letterToValMap = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var result = 0
        var formerVal = -1

        s.reversed().forEach {
            val tmp = letterToValMap[it]
            val currentNumber = if (formerVal <= tmp!!) {
                tmp
            } else {
                tmp * -1
            }
            result += currentNumber
            formerVal = tmp
        }

        return result
    }

    private fun romanToInt2(s: String): Int {
        val letterToValMap = hashMapOf(
            'I' to 1,
            'V' to 5,
            'X' to 10,
            'L' to 50,
            'C' to 100,
            'D' to 500,
            'M' to 1000
        )

        var result = 0
        var currentPointer: Int = s.lastIndex
        var nextPointer: Int = currentPointer - 1

        while (nextPointer > -1) {
            val current = letterToValMap[s[currentPointer]]!!
            val next = letterToValMap[s[nextPointer]]!!
            result = if (next < current) {
                result + (current * -1)
            } else {
                result + current
            }

            currentPointer--
            nextPointer--
        }

        result += letterToValMap[s.first()]!!

        return result
    }

    @Test
    fun test1() {
        assertEquals(3, romanToInt("III"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }

    @Test
    fun test2() {
        assertEquals(3, romanToInt2("III"))
        assertEquals(58, romanToInt2("LVIII"))
        assertEquals(9, romanToInt2("IX"))
        assertEquals(1994, romanToInt2("MCMXCIV"))
    }
}