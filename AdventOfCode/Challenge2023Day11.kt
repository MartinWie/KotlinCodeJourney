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
            // If the line does not contain any galaxies we can conviniently use it to add it to the expanded map
            if (line.replace(".", "").isEmpty()) map.add(line)
        }

        val finalMap = mutableListOf<String>()
        for (i in map.indices) {
            val tmpCharList = mutableListOf<Char>()
            for (j in lines.indices) {
                val currentChar = map[i][j]
                if (currentChar == '#') {
                    tmpCharList.add(currentChar)
                }
            }
            if (tmpCharList.isNotEmpty()) {
                for (j in lines.indices) {
                    // TODO: implement expansion for columns
                }
            }
        }

        // Implement Galaxy numeration (use currentGalaxyAmount)

        // Implement path calculation

        return lines.size
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day10-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(374, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day10-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(6701, solution1)
    }
}
