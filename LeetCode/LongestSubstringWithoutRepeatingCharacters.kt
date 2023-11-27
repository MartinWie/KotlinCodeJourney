import org.junit.Test
import kotlin.test.assertEquals

class LongestSubstringWithoutRepeatingCharacters {
    private fun lengthOfLongestSubstring(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        var maxStreak = 0
        for (outerLetter in s) {
            val hashMap = HashMap<Char, String>()
            var currentStreak = 0
            for (innerLetter in s) {
                if (hashMap.containsKey(innerLetter)) {
                    break
                } else {
                    hashMap[innerLetter] = ""
                    currentStreak++
                }
            }
            if (currentStreak > maxStreak) maxStreak = currentStreak
        }
        return maxStreak
    }

    @Test
    fun test() {
        assertEquals(3, lengthOfLongestSubstring("pwwkew"))
    }
}
