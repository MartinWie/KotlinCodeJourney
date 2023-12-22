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

            val numberRowsReversed = numberRows.reversed()

            var currentPredictedNumber = 0
            var formerRow: MutableList<Int>? = null

            for (row in numberRowsReversed) {
                val formerPredict = currentPredictedNumber
                if (formerRow != null) {
                    currentPredictedNumber = row.last() + formerPredict
                }

                formerRow = row.toMutableList()
                formerRow.add(formerPredict)
            }
            results.add(currentPredictedNumber)
        }

        return results.sum()
    }

    private fun solve2(lines: List<String>): Int {
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

            val numberRowsReversed = numberRows.reversed()

            var currentPredictedNumber = 0
            var formerRow: MutableList<Int>? = null

            for (row in numberRowsReversed) {
                val formerPredict = currentPredictedNumber
                if (formerRow != null) {
                    currentPredictedNumber = row.first() - formerPredict
                }

                formerRow = row.toMutableList()
                formerRow.add(formerPredict)
            }
            results.add(currentPredictedNumber)
        }

        return results.sum()
    }

    // Just for fun, here is th ecombined solution ->

    private fun solve(lines: List<String>): Pair<Int, Int> {
        var sum1 = 0
        var sum2 = 0

        lines.forEach { line ->
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

            val numberRowsReversed = numberRows.reversed()

            var currentPredictedNumber1 = 0
            var currentPredictedNumber2 = 0
            var formerRow: MutableList<Int>? = null

            for (row in numberRowsReversed) {
                val formerPredict1 = currentPredictedNumber1
                val formerPredict2 = currentPredictedNumber2

                if (formerRow != null) {
                    currentPredictedNumber1 = row.last() + formerPredict1
                    currentPredictedNumber2 = row.first() - formerPredict2
                }

                formerRow = row.toMutableList()
                formerRow.add(formerPredict1) // Only need to add for the first calculation
            }

            sum1 += currentPredictedNumber1
            sum2 += currentPredictedNumber2
        }

        return Pair(sum1, sum2)
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
        assertEquals(1861775706, solution1)

        val lines2 = File("./AdventOfCode/Data/Day09-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution2 = solve2(lines2)
        println("Example solution 2: $exampleSolution2")
        assertEquals(2, exampleSolution2)

        val realLines2 = File("./AdventOfCode/Data/Day09-1-Data.txt").bufferedReader().readLines()
        val solution2 = solve2(realLines2)
        println("Solution 2: $solution2")
        assertEquals(1082, solution2)
    }

    @Test
    fun `Test the combined solution`() {
        val exampleLines = File("./AdventOfCode/Data/Day09-1-Test-Data.txt").bufferedReader().readLines()
        val (exampleSolution1, exampleSolution2) = solve(exampleLines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(114, exampleSolution1)
        println("Example solution 2: $exampleSolution2")
        assertEquals(2, exampleSolution2)

        val realLines = File("./AdventOfCode/Data/Day09-1-Data.txt").bufferedReader().readLines()
        val (solution1, solution2) = solve(realLines)
        println("Solution 1: $solution1")
        assertEquals(1861775706, solution1)
        println("Solution 2: $solution2")
        assertEquals(1082, solution2)
    }
}
