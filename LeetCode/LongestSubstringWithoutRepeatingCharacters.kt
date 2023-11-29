import org.junit.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharacters {
    private fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        var currentString = s
        var maxStreak = 0
        var endOfStringReached = false
        while (currentString.isNotEmpty() && !endOfStringReached) {
            val hashMap = HashMap<Char, Int>()
            var currentStreak = 0
            for ((index, innerLetter) in currentString.withIndex()) {
                if (hashMap.containsKey(innerLetter)) {
                    currentString = currentString.drop(hashMap[innerLetter]!! + 1)
                    break
                } else {
                    hashMap[innerLetter] = index
                    currentStreak++
                    if (currentString.length == index + 1) endOfStringReached = true
                }
            }
            if (currentStreak > maxStreak) maxStreak = currentStreak
        }
        return maxStreak
    }

    @Test
    fun test() {
        assertEquals(3, lengthOfLongestSubstring("dvdf"))
        assertEquals(2, lengthOfLongestSubstring("aab"))
        assertEquals(3, lengthOfLongestSubstring("pwwkew"))
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"))
    }
}
