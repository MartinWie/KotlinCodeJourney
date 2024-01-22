import org.junit.Test
import kotlin.test.assertEquals

class InterviewQuestionCharSumInString {
    private fun solve1(s: String): HashMap<Char, Int> {
        val result = HashMap<Char, Int>()

        s.forEach {
                char ->
            if (result[char] == null) {
                result[char] = 1
            } else {
                result[char] = result[char]!! + 1
            }
        }

        return result
    }

    private fun solve2(s: String): HashMap<Char, Int> {
        val result = HashMap<Char, Int>()

        s.forEach {
                char ->
            result[char] = result.getOrDefault(char, 0) + 1
        }
        return result
    }

    private fun solve3(s: String): HashMap<Char, Int> {
        val result = HashMap<Char, Int>()

        for (char in s) {
            result[char] = (result[char] ?: 0) + 1
        }

        return result
    }

    @Test
    fun test() {
        val solution1 = solve1("Testt")

        val expected = hashMapOf('T' to 1, 'e' to 1, 's' to 1, 't' to 2)

        assertEquals(expected, solution1)

        val solution2 = solve2("Testt")

        assertEquals(expected, solution2)

        val solution3 = solve3("Testt")

        assertEquals(expected, solution3)
    }
}
