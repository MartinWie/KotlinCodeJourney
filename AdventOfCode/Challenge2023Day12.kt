import java.io.File
import kotlin.test.Test
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

            possibleSpringPositions.getCombinations(unassignedSprings).forEach {
                val tmpLine = StringBuilder(springRow)
                for (char in it) {
                    tmpLine[char] = '#'
                }
                if (isValidMap(tmpLine.toString(), controlNumbers)) {
                    result++
                }
            }
        }

        return result
    }

    private fun <T> List<T>.getCombinations(combLength: Int): List<List<T>> {
        if (combLength == 0) return listOf(emptyList())

        if (size <= combLength) return listOf(this)

        val head = take(1)
        val tail = drop(1)

        // All combinations with head
        val withHead = getCombinations(combLength - 1).map { head + it }

        // All combinations without head
        val withoutHead = tail.getCombinations(combLength)

        return withHead + withoutHead
    }

    private fun isValidMap(
        springRow: String,
        controlNumbers: List<Int>,
    ): Boolean {
        val pattern = Regex("#+")
        val matches = pattern.findAll(springRow)
        if (matches.count() != controlNumbers.size) return false
        matches.forEachIndexed {
                index, matchResult ->
            if (matchResult.value.length != controlNumbers[index]) {
                return false
            }
        }
        return true
    }

    @Test
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
