import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day06 {
    private fun solve1(lines: List<String>): Int {
        val times = getNumbers(lines.first())
        val records = getNumbers(lines.last())

        val winningAmounts = mutableListOf<Int>()

        for ((index, time) in times.withIndex()) {
            val winningHolds = mutableListOf<Int>()
            for (currentHoldTime in 0..time) {
                if (currentHoldTime * (time - currentHoldTime) > records[index]) winningHolds.add(currentHoldTime)
            }
            if (winningHolds.isNotEmpty()) winningAmounts.add(winningHolds.size)
        }


        return winningAmounts.reduce { acc, number -> acc * number }
    }

    private fun getNumbers(line: String): List<Int> {
        val regex = Regex("\\d+")
        return regex.findAll(line).map { it.value.toInt() }.toList()
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day06-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(288, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day06-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(3316275, solution1)
    }
}