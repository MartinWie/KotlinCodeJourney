import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day14 {
    private fun solve1(lines: List<String>): Int {
        var resultLoad = 0

        // TODO: go through each line starting at 1 and see if there is a round rock
        // Found rock -> move up until line 0 or encountered other rock.
        // Alternative path, on a row basis go through each row from 0 to n and store latest possible postition
        // use that to move any found rock, the store nex possible position(current + 1)

        // TOD0: implement result calculation
        // (go through each line and calculate weight)
        return resultLoad
    }

    fun test() {
        val lines = File("./AdventOfCode/Data/Day14-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(136, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day14-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(9623138, solution1)
    }
}
