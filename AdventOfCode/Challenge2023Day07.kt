import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day07 {
    private fun solve1(lines: List<String>): Int {
        val valueMap =
            mapOf(
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
                '2' to 2,
            )

        val hands = mutableListOf<Hand>()
        lines.forEach { line ->
            val (currentCardsRaw, winningAmountRaw) = line.split(" ")
            val currentCards = currentCardsRaw.map { valueMap[it]!! }
            val winningAmount = winningAmountRaw.toInt()
            val numberCounts = currentCards.groupingBy { it }.eachCount()
            val classification = classifyHand(numberCounts)

            val currentHand =
                Hand(
                    currentCards,
                    winningAmount,
                    numberCounts,
                    classification,
                )

            hands.add(currentHand)
        }

        val sortedHands =
            hands.sortedWith(
                compareBy<Hand> { it.classification }
                    .then {
                            h1, h2 ->
                        Hand.compare.compare(h1, h2)
                    },
            )

        var winningSum = 0

        sortedHands.forEachIndexed { index, hand ->
            winningSum += hand.winningAmount * (index + 1)
        }

        return winningSum
    }

    data class Hand(
        val currentCards: List<Int>,
        val winningAmount: Int,
        val numberCounts: Map<Int, Int>,
        val classification: Int,
    ) {
        companion object {
            val compare =
                Comparator { h1: Hand, h2: Hand ->
                    val minHandSize = minOf(h1.currentCards.size, h2.currentCards.size)
                    for (cardNum in 0 until minHandSize) {
                        val compareResult = h1.currentCards[cardNum].compareTo(h2.currentCards[cardNum])
                        if (compareResult != 0) return@Comparator compareResult
                    }

                    h1.currentCards.size.compareTo(h2.currentCards.size)
                }
        }
    }

    private fun classifyHand(numberCounts: Map<Int, Int>): Int {
        // For simplicity I will map the different types of hands to simple integers, this makes compares straight forward
        return when {
            // Five of a kind
            numberCounts.containsValue(5) -> 7
            // Four of a kind
            numberCounts.containsValue(4) -> 6
            // Full house
            numberCounts.containsValue(3) && numberCounts.containsValue(2) -> 5
            // Three of a kind
            numberCounts.containsValue(3) -> 4
            // Two pairs
            numberCounts.filter { it.value == 2 }.size == 2 -> 3
            // One pair
            numberCounts.filter { it.value == 2 }.size == 1 -> 2
            // No matches
            else -> 1
        }
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day07-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(6440, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day07-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(249748283, solution1)
    }
}
