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
    private val alreadyDoneMoves = hashMapOf<Triple<Int, Int, Direction>, Int>()

    private fun solve1(lines: List<String>): Int {
        setupField(lines)

        // Entering the map from the left side, so starting form WEST
        takeNextStep(0, 0, Direction.WEST)

        return calculateEnergizedTiles(mapEnergized)
    }

    private fun solve2(lines: List<String>): Int {
        var highestScore = 0

        // From top
        for (index in lines.first().indices) {
            setupField(lines)

            takeNextStep(index, 0, Direction.NORTH)
            val tmpEnergized = calculateEnergizedTiles(mapEnergized)
            if (tmpEnergized > highestScore) highestScore = tmpEnergized
        }

        // From bottom
        for (index in lines.first().indices) {
            setupField(lines)

            takeNextStep(index, lines.lastIndex, Direction.SOUTH)
            val tmpEnergized = calculateEnergizedTiles(mapEnergized)
            if (tmpEnergized > highestScore) highestScore = tmpEnergized
        }

        // From left
        for (index in lines.indices) {
            setupField(lines)

            takeNextStep(0, index, Direction.WEST)
            val tmpEnergized = calculateEnergizedTiles(mapEnergized)
            if (tmpEnergized > highestScore) highestScore = tmpEnergized
        }

        // From right
        for (index in lines.indices) {
            setupField(lines)

            takeNextStep(lines.first().lastIndex, index, Direction.EAST)
            val tmpEnergized = calculateEnergizedTiles(mapEnergized)
            if (tmpEnergized > highestScore) highestScore = tmpEnergized
        }

        return highestScore
    }

    private fun setupField(lines: List<String>) {
        // Clear out the global variables
        map.clear()
        mapEnergized.clear()
        alreadyDoneMoves.clear()


        lines.forEach {
            map.add(it)
            mapEnergized.add(it)
        }
    }

    private fun takeNextStep(x: Int, y: Int, cameFrom: Direction) {
        // Get out if light moves out of map
        if (x > map.first().lastIndex || y > map.lastIndex || x < 0 || y < 0) {
            return
        }

        // Get out if move was already done
        val currentStep = Triple(x, y, cameFrom)
        if (alreadyDoneMoves.contains(currentStep)) {
            return
        } else {
            alreadyDoneMoves[currentStep] = 1
        }

        val currentChar = map[y][x]

        // Energize the current tile
        mapEnergized[y] = mapEnergized[y].replace(x, '#')

        when (cameFrom) {
            Direction.NORTH -> {
                when (currentChar) {
                    '.' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '|' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '-' -> {
                        takeNextStep(x + Direction.EAST.x, y + Direction.EAST.y, Direction.EAST)
                        takeNextStep(x + Direction.WEST.x, y + Direction.WEST.y, Direction.WEST)
                    }

                    '/' -> takeNextStep(x + Direction.EAST.x, y + Direction.EAST.y, Direction.EAST)
                    '\\' -> takeNextStep(x + Direction.WEST.x, y + Direction.WEST.y, Direction.WEST)
                }
            }

            Direction.SOUTH -> {
                when (currentChar) {
                    '.' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '|' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '-' -> {
                        takeNextStep(x + Direction.EAST.x, y + Direction.EAST.y, Direction.EAST)
                        takeNextStep(x + Direction.WEST.x, y + Direction.WEST.y, Direction.WEST)
                    }

                    '/' -> takeNextStep(x + Direction.WEST.x, y + Direction.WEST.y, Direction.WEST)
                    '\\' -> takeNextStep(x + Direction.EAST.x, y + Direction.EAST.y, Direction.EAST)
                }
            }

            Direction.EAST -> {
                when (currentChar) {
                    '.' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '|' -> {
                        takeNextStep(x + Direction.NORTH.x, y + Direction.NORTH.y, Direction.NORTH)
                        takeNextStep(x + Direction.SOUTH.x, y + Direction.SOUTH.y, Direction.SOUTH)
                    }

                    '-' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '/' -> takeNextStep(x + Direction.NORTH.x, y + Direction.NORTH.y, Direction.NORTH)
                    '\\' -> takeNextStep(x + Direction.SOUTH.x, y + Direction.SOUTH.y, Direction.SOUTH)
                }
            }

            Direction.WEST -> {
                when (currentChar) {
                    '.' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '|' -> {
                        takeNextStep(x + Direction.NORTH.x, y + Direction.NORTH.y, Direction.NORTH)
                        takeNextStep(x + Direction.SOUTH.x, y + Direction.SOUTH.y, Direction.SOUTH)
                    }

                    '-' -> takeNextStep(x + cameFrom.x, y + cameFrom.y, cameFrom)
                    '/' -> takeNextStep(x + Direction.SOUTH.x, y + Direction.SOUTH.y, Direction.SOUTH)
                    '\\' -> takeNextStep(x + Direction.NORTH.x, y + Direction.NORTH.y, Direction.NORTH)
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
        assertEquals(7074, solution1)
    }

    @Test
    fun testSolve2() {
        val lines = File("./AdventOfCode/Data/Day16-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve2(lines)
        println("Example solution 2: $exampleSolution1")
        assertEquals(51, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day16-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve2(realLines)
        println("Solution 2: $solution1")
        assertEquals(7530, solution1)
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