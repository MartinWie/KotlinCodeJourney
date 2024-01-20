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
                    result += index + 1
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
                for (line in map) {
                    leftTmp = leftTmp.plus(line[leftLine.second])
                }
                leftLine = leftTmp to leftLine.second - 1
            }

            if (rightLine.second > map.first().lastIndex) {
                rightLine = null to rightLine.second
            } else {
                var rightTmp = ""
                for (line in map) {
                    rightTmp = rightTmp.plus(line[rightLine.second])
                }
                rightLine = rightTmp to rightLine.second + 1
            }

            if ((leftLine.first ?: rightLine.first) != (rightLine.first ?: leftLine.first)) {
                return false
            }
        }

        return true
    }

    private fun checkHorizontal(
        map: ArrayList<String>,
        lineNumber: Int,
    ): Boolean {
        if (lineNumber <= 0 || lineNumber >= map.lastIndex) return false

        var topLine: Pair<String?, Int> = "" to lineNumber
        var bottomLine: Pair<String?, Int> = "" to lineNumber + 1

        while (topLine.second > 0 || bottomLine.second < map.lastIndex) {
            topLine =
                if (topLine.second <= 0) {
                    null to topLine.second
                } else {
                    map[topLine.second] to topLine.second - 1
                }

            bottomLine =
                if (bottomLine.second > map.lastIndex) {
                    null to bottomLine.second
                } else {
                    map[bottomLine.second] to bottomLine.second + 1
                }

            if ((topLine.first ?: bottomLine.first) != (bottomLine.first ?: topLine.first)) {
                return false
            }
        }
        return true
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
