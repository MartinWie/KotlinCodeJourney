import org.junit.Test
import kotlin.test.assertEquals

class Challenge2023Day04 {

    private fun solve1(): Int {
        val numberList = mutableListOf<Int>()

        return numberList.sum()
    }

    @Test
    fun test() {
        val exampleSolution1 = solve1()
        println("Example solution 1: $exampleSolution1")
        assertEquals(4361, exampleSolution1)

        val solution1 = solve1()
        println("Solution 1: $solution1")
        assertEquals(546563, solution1)
    }
}
