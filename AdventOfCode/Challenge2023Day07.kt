import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day07 {
    private fun solve1(lines: List<String>): Int {
        val valueMap = mapOf(
            'A' to 14,
            'K' to 13,
            'Q' to 12,
            'J' to 11,
            'T' to 10,
            '9' to 9,
            '8' to 8,
            '7' to 7,
            '6' to 6,
            '5' to 5,
            '4' to 4,
            '3' to 3,
            '2' to 2
        )

        val (currentCardsRaw, winningAmountRaw) = lines[0].split(" ")
        val currentCards = currentCardsRaw.map { valueMap[it]!! }
        val winningAmount = winningAmountRaw.toInt()

        val currentHand = currentCards to winningAmount
        // check how often a number is in a list of numbers
        val numberCounts: Map<Int, Int> = currentHand.first.groupingBy { it }.eachCount()



        return 0
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day07-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(288, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day07-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(3316275, solution1)
    }
}