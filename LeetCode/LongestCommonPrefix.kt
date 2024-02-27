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

    @Test
    fun test() {
        assertEquals("fl", solve(arrayOf("flower", "flow", "flight")))
        assertEquals("", solve(arrayOf("dog", "racecar", "car")))
    }
}