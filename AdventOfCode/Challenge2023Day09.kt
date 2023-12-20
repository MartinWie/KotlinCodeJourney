import org.junit.Test
import java.io.File
import kotlin.math.abs
import kotlin.test.assertEquals

class Challenge2023Day09 {
    private fun solve1(lines: List<String>): Int {
        val results = mutableListOf<Int>()

        lines.forEach { line ->
            // Generate the relevant lines
            val initialNumbers = line.split(" ").map { it.toInt() }
            val numberRows = mutableListOf<List<Int>>()

            numberRows.add(initialNumbers)

            var currentRow = numberRows.first()

            while (currentRow.reduce { acc, i -> abs(i) + acc } != 0) {
                val newRow = mutableListOf<Int>()

                var formerNumber: Int? = null
                currentRow.forEach {
                    if (formerNumber != null) {
                        newRow.add(it - formerNumber!!)
                    }
                    formerNumber = it
                }

                numberRows.add(newRow)

                currentRow = numberRows.last()
            }

            numberRows.reversed()

            // TBD
        }

        return results.sum()
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
