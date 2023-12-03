import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day02 {

    private fun solve(gameConfig: GameConfig, file: String): Int {
        val games = File(file).bufferedReader().readLines()
        val validGamesIdList = mutableListOf<Int>()
        val allowedCubeColors = gameConfig.cubes.map { it.color }
        for (game in games) {
            val rounds = game.split(":")[1].split(";")
            var invalidGame = false
            for (round in rounds) {
                if (invalidGame) break
                val drawnCubes = round.split(",")
                for (cube in drawnCubes) {
                    if (invalidGame) break
                    val color = Regex("([a-z]+)").find(cube)?.groupValues?.first()
                    val amount = Regex("(\\d+)").find(cube)?.groupValues?.first()?.toInt()

                    if (color !in allowedCubeColors) {
                        invalidGame = true
                        break
                    }

                    val currentCube = gameConfig.cubes.find { it.color == color }

                    if ((currentCube?.maxAmount ?: 0) < amount!!) {
                        invalidGame = true
                        break
                    }
                }
            }
            if (!invalidGame) {
                val idRegex = Regex("(\\d+):")
                val gameId = idRegex.find(game)?.groupValues?.get(1)?.toInt()
                validGamesIdList.add(gameId!!)
            }
        }

        return validGamesIdList.sum()
    }

    data class GameConfig(val cubes: List<CubeConfig>)

    data class CubeConfig(
        val color: String,
        val maxAmount: Int,
    )

    @Test
    fun test() {
        val cubes = mutableListOf<CubeConfig>()

        // Example cubes: 12 red cubes, 13 green cubes, and 14 blue
        cubes.add(CubeConfig("red", 12))
        cubes.add(CubeConfig("green", 13))
        cubes.add(CubeConfig("blue", 14))
        val exampleSolution = solve(GameConfig(cubes), "./AdventOfCode/Data/Day02-1-Test-Data.txt")
        println("Solution Example: $exampleSolution")
        assertEquals(8, exampleSolution)

        val cubesChallenge = mutableListOf<CubeConfig>()

        // Example cubes: 12 red cubes, 13 green cubes, and 14 blue
        cubesChallenge.add(CubeConfig("red", 12))
        cubesChallenge.add(CubeConfig("green", 13))
        cubesChallenge.add(CubeConfig("blue", 14))
        val challangeSolution = solve(GameConfig(cubesChallenge), "./AdventOfCode/Data/Day02-1.txt")
        println("Solution 1: $challangeSolution")
    }
}
