import org.junit.Test
import kotlin.test.assertEquals

class LongestCommonPrefix {

    private fun solve(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        val resultChars = mutableListOf<Char>()
        val shortestLength = strs.minBy { it.length }.lastIndex
        var counter = 0
        val lastWord = strs.last()
        val strsWihtoutLast = strs.dropLast(1)

        loop@ while (counter <= shortestLength) {
            val compareChar = lastWord[counter]
            for (word in strsWihtoutLast) {
                if (word[counter] != compareChar) break@loop
            }
            resultChars.add(compareChar)
            counter++
        }

        return resultChars.joinToString("")
    }

    private fun solve2(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        var result = ""
        val shortestLength = strs.minBy { it.length }.lastIndex
        val firstWord = strs.last()
        val strsWihtoutLast = strs.dropLast(1)

        for (i in 0..shortestLength) {
            val compareChar = firstWord[i]
            for (word in strsWihtoutLast) {
                if (word[i] != compareChar) return result
            }
            result += compareChar
        }

        return result
    }

    private fun solve3(strs: Array<String>): String {
        if (strs.isEmpty()) return ""

        for (i in 0..strs.first().lastIndex) {
            val compChar = strs.first()[i]
            for (j in 1..strs.lastIndex) {
                if (i > strs[j].lastIndex || strs[j][i] != compChar) {
                    return strs.first().substring(0, i)
                }
            }
        }

        return strs.first()
    }

    private fun solve4(strs: Array<String>): String {
        if (strs.isEmpty()) return ""
        val first = strs.first()

        for (i in 0..first.lastIndex) {
            val compChar = first[i]
            for (j in 1..strs.lastIndex) {
                if (i > strs[j].lastIndex || strs[j][i] != compChar) {
                    return first.substring(0, i)
                }
            }
        }

        return strs.first()
    }

    @Test
    fun test() {
        assertEquals("fl", solve(arrayOf("flower", "flow", "flight")))
        assertEquals("", solve(arrayOf("dog", "racecar", "car")))
        assertEquals("", solve(arrayOf("", "")))
        assertEquals("a", solve(arrayOf("ab", "a")))
    }

    @Test
    fun test2() {
        assertEquals("fl", solve2(arrayOf("flower", "flow", "flight")))
        assertEquals("", solve2(arrayOf("dog", "racecar", "car")))
        assertEquals("", solve2(arrayOf("", "")))
        assertEquals("a", solve2(arrayOf("ab", "a")))
    }

    @Test
    fun test3() {
        assertEquals("fl", solve3(arrayOf("flower", "flow", "flight")))
        assertEquals("", solve3(arrayOf("dog", "racecar", "car")))
        assertEquals("", solve3(arrayOf("", "")))
        assertEquals("a", solve3(arrayOf("ab", "a")))
    }

    @Test
    fun test4() {
        assertEquals("fl", solve4(arrayOf("flower", "flow", "flight")))
        assertEquals("", solve4(arrayOf("dog", "racecar", "car")))
        assertEquals("", solve4(arrayOf("", "")))
        assertEquals("a", solve4(arrayOf("ab", "a")))
    }
}