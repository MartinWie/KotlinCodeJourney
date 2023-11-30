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

    private fun lengthOfLongestSubstring2(s: String): Int {
        if (s.isEmpty()) return 0
        if (s.length == 1) return 1
        val charSet = HashSet<Char>()
        var leftPointer = 0
        var maxStreak = 0

        for (currentPointer in s.indices) {
            while (charSet.contains(s[currentPointer])) {
                charSet.remove(s[leftPointer])
                leftPointer++
            }
            charSet.add(s[currentPointer])
            maxStreak = maxOf(maxStreak, currentPointer - leftPointer + 1)
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

    @Test
    fun test2() {
        assertEquals(3, lengthOfLongestSubstring2("dvdf"))
        assertEquals(2, lengthOfLongestSubstring2("aab"))
        assertEquals(3, lengthOfLongestSubstring2("pwwkew"))
        assertEquals(3, lengthOfLongestSubstring2("abcabcbb"))
    }
}
