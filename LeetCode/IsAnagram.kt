class IsAnagram {

    // First version trying to trick the system, by adding the ASCI int values together but the test account for such trickery
    // This would be very memory efficient :D
    fun isAnagram(s: String, t: String): Boolean {
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
    fun isAnagram2(s: String, t: String): Boolean {
        if (s.length != t.length) return false

        var controlString: String? = t

        for (char in s) {
            controlString = dropFirstAppearenceLetterFromString(char, controlString)
            if (controlString == null) return false
        }

        return true
    }

    private fun dropFirstAppearenceLetterFromString(char: Char, text: String?): String? {
        if (text == null) return null

        for (s in text) {
            if (s == char) return text.replaceFirst(s.toString(), "")
        }
        return null
    }

    // TODO: find simple solution
    //tbd
}