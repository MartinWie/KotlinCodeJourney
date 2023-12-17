import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day08 {

    private fun solve1(lines: List<String>): Int {

        var currentPointer = lines[2].take(3) // Get the starting key
        var steps = 0

        val moves = getMoves(lines.first())
        var moveIndex = 0
        val mapLines = getMapLines(lines.drop(2))

        while (currentPointer != "ZZZ") {
            val mapLine = mapLines[currentPointer]
            currentPointer = if (moves[moveIndex] == 'L') {
                mapLine!!.first
            } else {
                mapLine!!.second
            }
            steps++
            // moveIndex = (moveIndex + 1) % moves.size
            moveIndex++
            if (moveIndex >= moves.size) moveIndex = 0 // Wrap around if it reaches the end
        }
        return steps
    }

    private fun getMoves(firstLine: String) = firstLine.toCharArray()

    private fun getMapLines(lines: List<String>): Map<String, Pair<String, String>> {
        val mapLines = mutableMapOf<String, Pair<String, String>>()
        val nodeRegex = Regex("[A-Z]{3}")

        lines.forEach { line ->
            val matchesList = nodeRegex.findAll(line).toList()
            mapLines[matchesList[0].value] = matchesList[1].value to matchesList[2].value
        }

        return HashMap(mapLines)
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day08-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(2, exampleSolution1)

        val lines2 = File("./AdventOfCode/Data/Day08-1-Test-Data2.txt").bufferedReader().readLines()
        val exampleSolution2 = solve1(lines2)
        println("Example solution 2: $exampleSolution2")
        assertEquals(6, exampleSolution2)

        val realLines = File("./AdventOfCode/Data/Day08-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(249748283, solution1)
    }
}