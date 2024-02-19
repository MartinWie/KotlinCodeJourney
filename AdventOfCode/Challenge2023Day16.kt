import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day16 {
    enum class Direction {
        NORTH, SOUTH, EAST, WEST
    }

    private val map = mutableListOf<String>()
    private val mapEnergized = mutableListOf<String>()

    private fun solve1(lines: List<String>): Int {
        lines.forEach {
            map.add(it)
            mapEnergized.add(it)
        }

        // Entering the map from the left side, so starting form WEST
        takeNextStep(0, 0, Direction.WEST)

        return calculateEnergizedTiles(mapEnergized)
    }

    private fun takeNextStep(x: Int, y: Int, cameFrom: Direction) {
        // Get out if light moves out of map
        if (x > map.first().lastIndex || y > map.lastIndex || x < 0 || y < 0) {
            return
        }

        val currentChar = map[y][x]

        when (cameFrom) {
            Direction.NORTH -> TODO()
            Direction.SOUTH -> TODO()
            Direction.EAST -> TODO()
            Direction.WEST -> TODO()
        }
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