import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day10 {
    private fun solve1(lines: List<String>): Int {
        val results = mutableListOf<Int>()

        return results.sum() + lines.size
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day10-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(114, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day10-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(1861775706, solution1)
    }
}
