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


        var formerPointer = s.lastIndex
        var currentPointer = formerPointer - 1

        var result = letterToValMap[s.last()]!!

        while (currentPointer > -1) {
            val former = letterToValMap[s[formerPointer]]!!
            val current = letterToValMap[s[currentPointer]]!!
            result = if (former > current) {
                result + (current * -1)
            } else {
                result + current
            }

            currentPointer--
            formerPointer--
        }

        return result
    }

    private fun romanToInt3(s: String): Int {
        var formerPointer = s.lastIndex
        var currentPointer = formerPointer - 1

        var result = s.last().romanToInt()

        while (currentPointer > -1) {
            val former = s[formerPointer].romanToInt()
            val current = s[currentPointer].romanToInt()
            result = if (former > current) {
                result + (current * -1)
            } else {
                result + current
            }

            currentPointer--
            formerPointer--
        }

        return result
    }

    private fun Char.romanToInt(): Int {
        return when (this) {
            'I' -> 1
            'V' -> 5
            'X' -> 10
            'L' -> 50
            'C' -> 100
            'D' -> 500
            'M' -> 1000
            else -> 0
        }
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

    @Test
    fun test3() {
        assertEquals(3, romanToInt3("III"))
        assertEquals(58, romanToInt3("LVIII"))
        assertEquals(9, romanToInt3("IX"))
        assertEquals(1994, romanToInt3("MCMXCIV"))
    }
}