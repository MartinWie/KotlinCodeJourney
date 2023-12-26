import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day10 {
    private fun solve1(lines: List<String>): Int {
        // Initializing the map with '.' on every field
        val map = MutableList(lines.size) {MutableList(lines.size) {'.'} }
        var steps = 0
        var startingPosition = 0 to 0

        for ((y, line) in lines.withIndex()) {
            for ((x, char) in line.withIndex()) {
                if (char == 'S') startingPosition = x to y
                map[y][x] = char
            }
        }

        var currentPosition = startingPosition
        var forbiddenNext = 'X'
        while ( steps == 0 || currentPosition != startingPosition ) {

            val result = getNextPosition(currentPosition, map, forbiddenNext)
            currentPosition = result.first
            forbiddenNext = result.second

            steps++
        }

        return (steps / 2) + if (steps % 2 == 0) 0 else 1
    }
    private fun getNextPosition(
        position: Pair<Int, Int>,
        map: MutableList<MutableList<Char>>,
        forbiddenNext: Char
        ): Pair<Pair<Int, Int>, Char> {

        val currentChar = map[position.first][position.second]
        return when {
            // Below
            map[position.first + 1][position.second] in "|LJS" && forbiddenNext != 'S' -> {
                (position.first + 1 to position.second) to 'N'
            }

            // Right
            map[position.first][position.second + 1] in "-J7S" && forbiddenNext != 'E' -> {
                (position.first to position.second + 1) to 'W'
            }

            // Left
            map[position.first][position.second - 1] in "-LFS" && forbiddenNext != 'W' -> {
                (position.first to position.second - 1) to 'E'
            }

            // Above
            map[position.first - 1][position.second] in "|7FS" && forbiddenNext != 'N' -> {
                (position.first - 1 to position.second) to 'S'
            }

            else -> { error("How did we end here?") }
        }
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day10-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(4, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day10-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(1861775706, solution1)
    }
}
