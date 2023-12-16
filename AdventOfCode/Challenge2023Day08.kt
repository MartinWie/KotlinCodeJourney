import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day08 {

    private fun solve1(lines: List<String>): Int {
        return 0
    }

    fun test() {
        val lines = File("./AdventOfCode/Data/Day08-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(6440, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day08-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(249748283, solution1)
    }
}