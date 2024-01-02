import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day11 {
    private fun solve1(lines: List<String>): Int {
        var currentGalaxyAmount = 0
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
        val finalMap = mutableListOf<String>()
        for(line in expandedMap) {
            val newLine = StringBuilder()
            for (char in line) {
                if (char == '#') {
                    newLine.append(currentGalaxyAmount)
                    currentGalaxyAmount++
                } else {
                    newLine.append(char)
                }
            }
            finalMap.add(newLine.toString())
        }

        // Implement path calculation

        return lines.size
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
        assertEquals(6701, solution1)
    }
}
