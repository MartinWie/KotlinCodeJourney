import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day04 {

    private fun solve1(lines: List<String>): Int {
        val numberList = mutableListOf<Int>()
        val games = lines.map { lineToGameNumbers(it) }

        games.forEach { game ->
            var currentWinCounter = 0
            game.second.forEach { ownNumber ->
                if (game.first.contains(ownNumber)) {
                    if (currentWinCounter == 0) {
                        currentWinCounter++
                    } else {
                        currentWinCounter *= 2
                    }
                }
            }
            numberList.add(currentWinCounter)
        }

        return numberList.sum()
    }

    private fun splitAndMapToNumbers(str: String): List<Int> = str.trim().split(" ").map { it.toInt() }

    private fun lineToGameNumbers(line: String): Pair<HashSet<Int>, List<Int>> {
        val rawGame = line.replace("  ", " ").split(":")[1].split("|")
        val winningNumbersHashSet = splitAndMapToNumbers(rawGame[0]).toHashSet()
        val ownNumbers = splitAndMapToNumbers(rawGame[1])

        return winningNumbersHashSet to ownNumbers
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day04-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(13, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day04-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(26426, solution1)
    }
}
