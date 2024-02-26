import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day17 {

    private fun solve1(lines: List<String>): Int {
        // Looks a lot like a weighted graph traversal
        // TODO: brush up on weighted graph knowledge
        // (probably Dijkstra with some minor mod (max 3 steps in same direction))

        val start = Pair(0, 0)
        val end = Pair(lines.first().lastIndex, lines.lastIndex)

        val visited = mutableListOf<Pair<Int, Int>>()
        val nodes = mutableMapOf<Pair<Int, Int>, Int>()
        val travelCosts = mutableMapOf<Pair<Int, Int>, Int>()

        for (y in lines.indices) {
            for (x in lines.first().indices) {
                nodes[Pair(x, y)] = lines[y][x].digitToInt()
                travelCosts[Pair(x, y)] = 999999
            }
        }

        visited.add(start)
        travelCosts[start] = 0

        // TODO: finish implementation(do not forget to implement constraint(max 3 in same direction))

        return lines.size
    }

    @Test
    fun `Test solve1`() {
        val lines = File("./AdventOfCode/Data/Day17-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(102, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day17-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(1, solution1)
    }
}