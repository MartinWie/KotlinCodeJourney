import org.junit.Test
import java.io.File
import java.lang.IllegalArgumentException
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class Challenge2023Day01 {
    private fun solve1(): Int {
        val lines = File("./AdventOfCode/Data/Day01-1.txt").bufferedReader().readLines()
        val numberList = mutableListOf<Int>()
        for (line in lines) {
            val currentNumber = "${getFirstDigitAsChar(line)}${getLastDigitAsChar(line)}"
            numberList.add(currentNumber.toInt())
        }
        return numberList.sum()
    }

    private fun getFirstDigitAsChar(text: String): Char {
        for (char in text) {
            if (char.isDigit()) return char
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private fun getLastDigitAsChar(text: String): Char {
        val reversedText = text.reversed()
        for (char in reversedText) {
            if (char.isDigit()) return char
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private fun solve2(): Int {
        val lines = File("./AdventOfCode/Data/Day01-1.txt").bufferedReader().readLines()
        val numberList = mutableListOf<Int>()
        for (line in lines) {
            val currentNumber = "${getFirstDigit(line)}${getLastDigit(line)}"
            numberList.add(currentNumber.toInt())
        }
        return numberList.sum()
    }

    private fun getFirstDigit(text: String): Int {
        val charList = mutableListOf<Char>()
        for (char in text) {
            charList.add(char)
            if (charList.size > 2) {
                val stringBeforeNumber = charList.joinToString(separator = "")
                for (numberString in numberStringList) {
                    if (stringBeforeNumber.contains(numberString.key)) return numberString.value
                }
            }

            if (char.isDigit()) {
                return char.digitToInt()
            }
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private fun getLastDigit(text: String): Int {
        val reversedText = text.reversed()
        val charList = mutableListOf<Char>()
        for (char in reversedText) {
            charList.add(char)
            if (charList.size > 2) {
                val stringBeforeNumber = charList.joinToString(separator = "").reversed()
                for (numberString in numberStringList) {
                    if (stringBeforeNumber.contains(numberString.key)) return numberString.value
                }
            }
            if (char.isDigit()) {
                return char.digitToInt()
            }
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private val numberStringList =
        mutableMapOf("one" to 1, "two" to 2, "three" to 3, "four" to 4, "five" to 5, "six" to 6, "seven" to 7, "eight" to 8, "nine" to 9)

    private fun solve3(): Int {
        val lines = File("./AdventOfCode/Data/Day01-1.txt").bufferedReader().readLines()
        val numberList = mutableListOf<Int>()
        for (line in lines) {
            val currentNumber = "${getFirstDigit3(line)}${getLastDigit3(line)}"
            numberList.add(currentNumber.toInt())
        }
        return numberList.sum()
    }

    private fun getFirstDigit3(text: String): Int {
        val charList = mutableListOf<Char>()
        for (char in text) {
            charList.add(char)
            val currentSubString = charList.joinToString(separator = "")
            val found = findNumber(currentSubString)
            if (found != null) return found
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private fun getLastDigit3(text: String): Int {
        val reversedText = text.reversed()
        val charList = mutableListOf<Char>()
        for (char in reversedText) {
            charList.add(char)
            val currentSubString = charList.joinToString(separator = "").reversed()
            val found = findNumber(currentSubString)
            if (found != null) return found
        }
        throw IllegalArgumentException("No digit in text: $text")
    }

    private fun findNumber(text: String): Int? {
        val regex = Regex("(one|two|three|four|five|six|seven|eight|nine)|\\d")
        val found = regex.find(text)
        return when {
            found == null -> null
            found.value.length > 1 -> numberStringList[found.value]
            else -> found.value.toInt()
        }
    }

    @Test
    fun test() {
        println("Solution 1: ${solve1()}")
        println("Solution 2: ${solve2()}")
        println("Solution 3: ${solve3()}")
        assertEquals(57346, solve1())
        assertEquals(57345, solve2())
        assertEquals(57345, solve3())
        assertTrue { true }
    }
}
