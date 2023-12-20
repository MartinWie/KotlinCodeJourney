class IsAnagram {
    // First version trying to trick the system, by adding the ASCI int values together but the test account for such trickery
    // This would be very memory efficient :D
    fun isAnagram(
        s: String,
        t: String,
    ): Boolean {
        if (s.length != t.length) return false

        var asciValueS = 0
        var asciValueT = 0

        for (char in s) {
            asciValueS += char.code
        }

        for (char in t) {
            asciValueT += char.code
        }

        return asciValueS == asciValueT
    }

    // Version 2: Dumb brute force utilizing a helper function for better readibility
    // Going through every letter and check if there is a proper counter part in the other string
    fun isAnagram2(
        s: String,
        t: String,
    ): Boolean {
        if (s.length != t.length) return false

        var controlString: String? = t

        for (char in s) {
            controlString = dropFirstAppearenceLetterFromString(char, controlString)
            if (controlString == null) return false
        }

        return true
    }

    private fun dropFirstAppearenceLetterFromString(
        char: Char,
        text: String?,
    ): String? {
        if (text == null) return null

        for (s in text) {
            if (s == char) return text.replaceFirst(s.toString(), "")
        }
        return null
    }

    // A bit better but there must be a better solution, lets search for other approaches...
    fun isAnagram3(
        s: String,
        t: String,
    ): Boolean {
        if (s == t) return true
        if (s.length != t.length) return false

        val sHashMap = s.toAnagramHashMap()
        val tHashMap = t.toAnagramHashMap()

        if (sHashMap.size != tHashMap.size) return false

        return sHashMap == tHashMap
    }

    private fun String.toAnagramHashMap(): HashMap<Char, Int> {
        val hashMap = hashMapOf<Char, Int>()
        this.forEach { c ->
            if (hashMap.containsKey(c)) {
                hashMap[c] = hashMap[c]!! + 1
            } else {
                hashMap[c] = 1
            }
        }
        return hashMap
    }

    // Final solution for now there are more memory efficient solutionsliek working with an IntArray, but this is sufficient enough for now
    fun isAnagram4(
        s: String,
        t: String,
    ): Boolean {
        if (s == t) return true
        if (s.length != t.length) return false

        val hasMap = hashMapOf<Char, Int>()

        s.forEach {
            if (hasMap.containsKey(it)) {
                hasMap[it] = hasMap[it]!! + 1
            } else {
                hasMap[it] = 1
            }
        }

        t.forEach {
            if (hasMap.containsKey(it)) {
                hasMap[it] = hasMap[it]!! - 1
                if (hasMap[it]!! < 0) return false
            } else {
                return false
            }
        }
        return true
    }
}
