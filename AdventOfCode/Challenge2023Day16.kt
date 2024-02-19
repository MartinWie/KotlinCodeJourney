import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day16 {

    private fun solve1(lines: List<String>): Int {
        val map = lines.toMutableList()
        // TODO: implement recursive movement function
        // Notes: Mark energized tiles by '#' recursive end is if current tile is '#' and next is also '#'


        return calculateEnergizedTiles(map)
    }

    private fun calculateEnergizedTiles(map: MutableList<String>): Int {
        return map.reduce { acc, s ->
            acc.plus(s)
        }.count {
            it == '#'
        }
    }

    @Test
    fun testSolve1() {
        val lines = File("./AdventOfCode/Data/Day16-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(46, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day16-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(507769, solution1)
    }

    @Test
    fun `Test energized calculation`() {
        // Mock map with 3 energized tiles
        val mockMap = mutableListOf(
            "....#..",
            ".#.....",
            "...#..."
        )
        val energizedTiles = calculateEnergizedTiles(mockMap)
        assertEquals(3, energizedTiles, "The number of energized tiles should be 3.")
    }
}