import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day03 {
    private fun solve1(schema: List<String>): Int {
        val numberList = mutableListOf<Int>()
        var formerLine: String? = null
        var currentLine: String
        var nextLine: String?
        val nummerRegex = Regex("(\\d+)")

        for (lineNumber in schema.indices) {
            if (lineNumber > 0) {
                formerLine = schema[lineNumber - 1]
            }
            currentLine = schema[lineNumber]

            nextLine =
                if (schema.last() == schema[lineNumber]) {
                    null
                } else {
                    schema[lineNumber + 1]
                }

            nummerRegex.findAll(currentLine).forEach { match ->
                val startIndex = match.range.first
                val endIndex = match.range.last

                if (isNextToSymbol(formerLine, currentLine, nextLine, Pair(startIndex, endIndex))) {
                    numberList.add(match.value.toInt())
                }
            }
        }

        return numberList.sum()
    }

    private fun isNextToSymbol(
        formerLine: String?,
        currentLine: String,
        nextLine: String?,
        positionToCheck: Pair<Int, Int>,
    ): Boolean {
        val beginPointer = if (positionToCheck.first - 1 >= 0) positionToCheck.first - 1 else 0
        val endPointer = if (positionToCheck.second + 1 <= currentLine.length) positionToCheck.second + 1 else currentLine.length
        val subSequenceEndPointer = if (endPointer + 1 <= currentLine.length) endPointer + 1 else currentLine.length

        if (formerLine != null) {
            for (char in formerLine.subSequence(beginPointer, subSequenceEndPointer)) {
                if (char.isSymbol()) return true
            }
        }

        if (beginPointer > 0 && currentLine[positionToCheck.first - 1].isSymbol()) return true

        if (endPointer < currentLine.length && currentLine[positionToCheck.second + 1].isSymbol()) return true

        if (nextLine != null) {
            for (char in nextLine.subSequence(beginPointer, subSequenceEndPointer)) {
                if (char.isSymbol()) return true
            }
        }

        return false
    }

    private fun Char.isSymbol(): Boolean {
        return (this != '.' && !this.isLetterOrDigit())
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day03-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(4361, exampleSolution1)

        val linesReal = File("./AdventOfCode/Data/Day03-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(linesReal)
        println("Solution 1: $solution1")
        assertEquals(546563, solution1)
    }
}
