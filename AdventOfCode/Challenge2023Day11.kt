import org.junit.Test
import java.io.File
import kotlin.math.abs
import kotlin.test.assertEquals

class Challenge2023Day11 {
    private fun solve1(lines: List<String>): Int {
        val map = mutableListOf<String>()
        // First lets expand the map
        for (line in lines) {
            map.add(line)
            // If the line does not contain any galaxies we can conveniently use it to add it to the expanded map
            if (line.replace(".", "").isEmpty()) map.add(line)
        }

        val columnsToExpand =
            (0 until map[0].length).map { columnIndex ->
                map.all { row -> row[columnIndex] == '.' }
            }

        val expandedMap =
            map.map { row ->
                row.mapIndexed { index, char ->
                    if (columnsToExpand[index]) "$char$char" else char
                }.joinToString("")
            }

        // Implement Galaxy numeration (use currentGalaxyAmount)
        // More efficient would be to also do the galaxy enumeration in the former steps.
        // (Decision here readability > performance)
        // The list "finalMap" is currently not necessary, but I will keep it for now
        var currentGalaxyAmount = 0
        val finalMap = mutableListOf<String>()
        val galaxyCords = mutableListOf<Pair<Int, Int>>()
        for ((y, line) in expandedMap.withIndex()) {
            val newLine = StringBuilder()
            for ((x, char) in line.withIndex()) {
                if (char == '#') {
                    newLine.append(currentGalaxyAmount)
                    currentGalaxyAmount++
                    galaxyCords.add(x to y)
                } else {
                    newLine.append(char)
                }
            }
            finalMap.add(newLine.toString())
        }

        // Implement path calculation
        val pathsHashMap = HashMap<Pair<Pair<Int, Int>, Pair<Int, Int>>, Int>()
        for (pos1 in galaxyCords) {
            for (pos2 in galaxyCords) {
                if(pathsHashMap[pos1 to pos2] == null && pathsHashMap[pos2 to pos1] == null ) {
                pathsHashMap[pos1 to pos2] = (abs(pos1.first - pos2.first) + abs(pos1.second - pos2.second))
                }
            }
        }

        return pathsHashMap.values.sum()
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day11-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(374, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day11-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }
}
