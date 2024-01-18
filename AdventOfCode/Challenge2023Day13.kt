import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day13 {
    private fun solve1(lines: List<String>): Int {
        var result = 0
        val maps = mutableListOf<ArrayList<String>>()
        var mapCreationPosition = 0

        lines.forEach { line ->
            if (line.isEmpty()) {
                mapCreationPosition++
            } else {
                if (mapCreationPosition >= maps.size) maps.add(ArrayList())
                maps[mapCreationPosition].add(line)
            }
        }

        for (map in maps) {
            // Check all vertical lines of a given map + if found add number to result
            for (index in map.indices) {
                if (checkVertical(map, index)) {
                    result += index
                    break
                }
            }

            // Check all horizontal lines of a given map + if found * 100 then add number to result
            for (index in map.indices) {
                if (checkVertical(map, index)) {
                    result += (index * 100)
                    break
                }
            }
        }

        return result
    }

    private fun checkVertical(
        map: ArrayList<String>,
        lineNumber: Int,
    ): Boolean {
        if (lineNumber == 0 || lineNumber >= map.first().lastIndex) return false

        var leftLine: Pair<String?, Int> = "" to lineNumber
        var rightLine: Pair<String?, Int> = "" to lineNumber + 1

        while (leftLine.second > 0 || rightLine.second < map.first().lastIndex) {
            if (leftLine.second <= 0) {
                leftLine = null to leftLine.second
            } else {
                var leftTmp = ""
                // TODO: for () build new compare string
                leftLine = leftTmp to leftLine.second
            }

            if (rightLine.second >= map.first().lastIndex) {
                rightLine = null to rightLine.second
            } else {
                var rightTmp = ""
                // TODO: for () build new compare string
                rightLine = rightTmp to rightLine.second + 1
            }

            if ((leftLine.first ?: rightLine.first) != (rightLine.first ?: leftLine.first)) return false
        }

        return true
    }

    private fun checkHorizontal(
        map: ArrayList<String>,
        lineNumber: Int,
    ): Boolean {
        // TODO: Implement
        return false
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day13-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(405, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day13-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }
}
