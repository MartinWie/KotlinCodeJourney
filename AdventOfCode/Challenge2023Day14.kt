import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day14 {
    private fun solve1(lines: List<String>): Int {
        val map = mutableListOf<String>()
        map.addAll(lines)

        var resultLoad = 0
        val highestIndex = map.indices.last

        for (rowNum in 0..highestIndex) {
            var columnPointer = 0
            var validColumnPosition = 0

            while (columnPointer <= highestIndex) {
                val currentChar = map[columnPointer][rowNum]
                when (currentChar) {
                    'O' -> {
                        map[columnPointer] = map[columnPointer].set(rowNum, '.')
                        map[validColumnPosition] = map[validColumnPosition].set(rowNum, 'O')
                        validColumnPosition++
                    }

                    '#' -> {
                        validColumnPosition = columnPointer + 1
                    }

                    '.' -> {
                        // Empty block, nothing to do here!
                    }

                    else -> throw IllegalStateException("Illegal char -> $currentChar")
                }
                columnPointer++
            }
        }

        // TODO: go through each line starting at 1 and see if there is a round rock
        // Found rock -> move up until line 0 or encountered other rock.
        // Alternative path, on a row basis go through each row from 0 to n and store latest possible postition
        // use that to move any found rock, the store nex possible position(current + 1)

        // TOD0: implement result calculation
        // (go through each line and calculate weight)

        // Alternative calculate when moving the 'O's
        return resultLoad
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day14-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(136, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day14-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }

    @Test
    fun `Helper Method test`() {
        val testString = "123456789"
        val result = testString.set(1, '0')
        assertEquals("103456789", result)

        val result2 = testString.set(0, '0')
        assertEquals("023456789", result2)

        val result3 = testString.set(testString.lastIndex, '0')
        assertEquals("123456780", result3)
    }
}

private operator fun String.set(replacementIndex: Int, value: Char): String {
    return this.take(replacementIndex) + value + this.drop(replacementIndex + 1)
}
