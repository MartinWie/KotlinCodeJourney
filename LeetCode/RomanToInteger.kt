import org.junit.Test
import kotlin.test.assertEquals

class RomanToInteger {
    fun romanToInt(s: String): Int {
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

    @Test
    fun test1() {
        assertEquals(3, romanToInt("III"))
        assertEquals(58, romanToInt("LVIII"))
        assertEquals(1994, romanToInt("MCMXCIV"))
    }
}