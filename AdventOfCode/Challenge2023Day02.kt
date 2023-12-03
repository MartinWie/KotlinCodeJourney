import org.junit.Test
import java.io.File
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Challenge2023Day02 {

    private fun solve(): Int {
        val gameData = File("./AdventOfCode/Data/Day02-1-Test-Data.txt").bufferedReader().readLines()
        val validGamesIdList = mutableListOf<Int>()

        // TODO: implement

        return validGamesIdList.sum()
    }

    @Test
    fun test() {
        println("Solution 1: ${solve()}")
        assertEquals(57346, solve())
        assertTrue { true }
    }
}
