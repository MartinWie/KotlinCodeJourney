import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day12 {
    private fun solve1(lines: List<String>): Int {
        var result = 0
        lines.forEach { line ->
            val (springRow, controlRow) = line.split(" ")
            val controlNumbers = controlRow.split(",").map { it.toInt() }
            val totalSprings = controlNumbers.sum()

            val unassignedSprings = totalSprings - springRow.count { it == '#' }

            // Determin unassigned positions (index values should be enough(evaluate later))

            // Get all combinations

            // Check each combination if the arrangement is valid -> yes result++
        }

        return result
    }

    fun test() {
        val lines = File("./AdventOfCode/Data/Day12-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(21, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day12-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }
}
