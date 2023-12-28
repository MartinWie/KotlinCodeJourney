import org.junit.Test
import java.io.File
import kotlin.math.ceil
import kotlin.test.assertEquals

class Challenge2023Day10 {
    data class Coord(val row: Int, val col: Int)

    private fun solve1(map: List<String>): Int {
        val startCoord =
            map.withIndex().find { (_, line) -> 'S' in line }
                ?.let { Coord(it.index, it.value.indexOf('S')) }

        var prev: Coord? = null
        var current = startCoord
        var steps = 0

        while (true) {
            val adjacent = findAdjacentCoords(current!!, map).firstOrNull { it != prev }
            steps++

            if (adjacent == null || adjacent == startCoord) {
                break
            }

            prev = current
            current = adjacent
        }

        return ceil(steps.toDouble() / 2).toInt()
    }

    private fun findAdjacentCoords(
        coord: Coord,
        map: List<String>,
    ): List<Coord> {
        val adj = mutableListOf<Coord>()

        // Check the coordinate above
        if (coord.row > 0 && "S|JL".contains(map[coord.row][coord.col])) {
            if ("|7F".contains(map[coord.row - 1][coord.col])) {
                adj.add(Coord(coord.row - 1, coord.col))
            }
        }

        // Check the coordinate below
        if (coord.row < map.size - 1 && "S|7F".contains(map[coord.row][coord.col])) {
            if ("|JL".contains(map[coord.row + 1][coord.col])) {
                adj.add(Coord(coord.row + 1, coord.col))
            }
        }

        // Check the coordinate to the left
        if (coord.col > 0 && "S-7J".contains(map[coord.row][coord.col])) {
            if ("-FL".contains(map[coord.row][coord.col - 1])) {
                adj.add(Coord(coord.row, coord.col - 1))
            }
        }

        // Check the coordinate to the right
        if (coord.col < map[0].length - 1 && "S-LF".contains(map[coord.row][coord.col])) {
            if ("-J7".contains(map[coord.row][coord.col + 1])) {
                adj.add(Coord(coord.row, coord.col + 1))
            }
        }

        return adj
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day10-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(4, exampleSolution1)

        val lines2 = File("./AdventOfCode/Data/Day10-1-Test-Data2.txt").bufferedReader().readLines()
        val exampleSolution2 = solve1(lines2)
        println("Example solution 1: $exampleSolution2")
        assertEquals(4, exampleSolution2)

        val realLines = File("./AdventOfCode/Data/Day10-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(6701, solution1)
    }
}
