import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day03 {
    private fun solve1(schema: List<String>): Int {
        val numberList = mutableListOf<Int>()
        for (line in schema) {

        }

        return numberList.sum()
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day03-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Solution 1: $exampleSolution1")
        assertEquals(4361, exampleSolution1)
    }
}
