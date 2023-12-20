import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day09 {

    private fun solve1(lines: List<String>): Int {

        return 0
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day09-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(114, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day09-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(18673, solution1)
    }
}