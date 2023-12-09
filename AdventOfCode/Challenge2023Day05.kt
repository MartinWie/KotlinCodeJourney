import org.junit.Test
import java.io.File
import kotlin.test.assertEquals

class Challenge2023Day05 {
    private fun solve1(lines: List<String>): Long {
        val seedsLine = lines.first()
        val seeds = seedsLine.split(":")[1].trim().split(" ").map { it.toLong() to 0 }.toMutableList()
        var currentMappingCounter = 0

        val mappingLines = lines.subList(1, lines.lastIndex + 1)
        mappingLines.forEach { line ->
            when {
                // Lines that indicate the start of a new mapping
                line.contains(":") -> currentMappingCounter++

                // Empty lines indicate that the mapping is over
                line.trim().isEmpty() -> {
                    val tmpSeeds = mutableListOf<Pair<Long, Int>>()
                    currentMappingCounter++
                    seeds.forEach {
                        if (it.second < currentMappingCounter) {
                            tmpSeeds.add(it.first to currentMappingCounter)
                        } else {
                            tmpSeeds.add(it)
                        }
                    }
                    seeds.clear()
                    seeds.addAll(tmpSeeds)
                }

                // Lines that contain the actual mapping
                else -> {
                    val mappingsRaw = line.split(" ").map { it.toLong() }
                    val sourceStart = mappingsRaw.first()
                    val targetStart = mappingsRaw[1]
                    val range = mappingsRaw.last()
                    val tmpSeeds = mutableListOf<Pair<Long, Int>>()

                    seeds.forEach{ seed ->
                        if (
                            seed.second < currentMappingCounter && (seed.first in sourceStart..<(sourceStart + range))
                            )
                        {
                            val newValue = (seed.first - sourceStart) + targetStart
                            tmpSeeds.add(newValue to currentMappingCounter)
                        } else {
                            tmpSeeds.add(seed)
                        }
                    }
                    seeds.clear()
                    seeds.addAll(tmpSeeds)
                }
            }
        }

        var currentLowestDistance = seeds.first().first
        seeds.forEach {
            if (it.first < currentLowestDistance) currentLowestDistance = it.first
        }

        return currentLowestDistance
    }

    @Test
    fun test() {
        val lines = File("./AdventOfCode/Data/Day05-1-Test-Data.txt").bufferedReader().readLines()
        val exampleSolution1 = solve1(lines)
        println("Example solution 1: $exampleSolution1")
        assertEquals(35, exampleSolution1)

        val realLines = File("./AdventOfCode/Data/Day05-1-Data.txt").bufferedReader().readLines()
        val solution1 = solve1(realLines)
        println("Solution 1: $solution1")
        assertEquals(26426, solution1)
    }
}