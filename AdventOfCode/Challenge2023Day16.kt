import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day16 {
    enum class Direction(val x: Int, val y: Int) {
        NORTH(0, 1),
        SOUTH(0, -1),
        EAST(-1, 0),
        WEST(1, 0)
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

        // Energize the current tile
        mapEnergized[y] = mapEnergized[y].replace(x, '#')

        when (cameFrom) {
            Direction.NORTH -> {
                when (currentChar) {
                    '.' -> takeNextStep(
                        x + cameFrom.x,
                        y + cameFrom.y,
                        Direction.NORTH
                    ) // TODO: think about proper movement and later optimize this
                    '|' -> TODO()
                    '-' -> TODO()
                    '/' -> TODO()
                    '\\' -> TODO()
                }
            }

            Direction.SOUTH -> {
                when (currentChar) {
                    '.' -> TODO()
                    '|' -> TODO()
                    '-' -> TODO()
                    '/' -> TODO()
                    '\\' -> TODO()
                }
            }

            Direction.EAST -> {
                when (currentChar) {
                    '.' -> TODO()
                    '|' -> TODO()
                    '-' -> TODO()
                    '/' -> TODO()
                    '\\' -> TODO()
                }
            }

            Direction.WEST -> {
                when (currentChar) {
                    '.' -> TODO()
                    '|' -> TODO()
                    '-' -> TODO()
                    '/' -> TODO()
                    '\\' -> TODO()
                }
            }
        }
    }

    private fun String.replace(index: Int, char: Char): String {
        return this.take(index) + char + this.drop(index + 1)
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
    fun `test energized calculation`() {
        // Mock map with 3 energized tiles
        val mockMap = mutableListOf(
            "....#..",
            ".#.....",
            "...#..."
        )
        val energizedTiles = calculateEnergizedTiles(mockMap)
        assertEquals(3, energizedTiles, "The number of energized tiles should be 3.")
    }

    @Test
    fun `test String replace helper function`() {
        assertEquals("AAA", "AAB".replace(2, 'A'))
    }
}