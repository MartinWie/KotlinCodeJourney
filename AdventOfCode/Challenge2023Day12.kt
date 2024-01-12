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

            val possibleSpringPositions =
                springRow.mapIndexedNotNull { index, char ->
                    if (char == '?') index else null
                }

            // Get all combinations(use unassigned amount(remaining missing springs) + possible positions)

            // Check each combination if the arrangement is valid -> yes result++
            // isValidMap is now implemented, now need the other open points
        }

        return result
    }

    private fun isValidMap(
        springRow: String,
        controlNumbers: List<Int>,
    ): Boolean {
        val pattern = Regex("#+")
        val matches = pattern.findAll(springRow)
        matches.forEachIndexed {
                index, matchResult ->
            if (matchResult.value.length != controlNumbers[index]) return false
        }
        return true
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
