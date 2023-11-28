import org.junit.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharacters {
    private fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        var currentString = s
        var maxStreak = 0
        while (currentString.length > 0) {
            val hashMap = HashMap<Char, String>()
            var currentStreak = 0
            for (innerLetter in currentString) {
                if (hashMap.containsKey(innerLetter)) {
                    break
                } else {
                    hashMap[innerLetter] = ""
                    currentStreak++
                    currentString = currentString.drop(1)
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
