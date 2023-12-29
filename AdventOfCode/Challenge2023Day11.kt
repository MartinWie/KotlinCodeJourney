import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day11 {

    private fun solve1(lines: List<String>): Int {
        return lines.size
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day10-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(4, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day10-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(6701, solution1)
    }
}