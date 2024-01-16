import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day13 {
    private fun solve1(lines: List<String>): Int {
        var result = 0

        // Create list of maps

        // Check all vertical lines of a given map + if found add number to result

        // Check all horizontal lines of a given map + if found * 100 then add number to result

        return result
    }

    private fun checkVertical(
        map: Array<Char>,
        lineNumber: Int,
    ): Boolean {
        // TODO: Implement
        return false
    }

    private fun checkHorizontal(
        map: Array<Char>,
        lineNumber: Int,
    ): Boolean {
        // TODO: Implement
        return false
    }

    fun test() {
        val lines = File("./AdventOfCode/Data/Day13-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(405, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day13-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }
}
