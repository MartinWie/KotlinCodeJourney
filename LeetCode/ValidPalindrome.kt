class ValidPalindrome {
    // Thanks to Kotlins filter with the Char.isLetterOrDigit() this is pretty straight forward
    fun isPalindrom(s: String): Boolean {
        val sOnlyLetters = s.lowercase().filter { it.isLetterOrDigit() }
        val checkUntil = sOnlyLetters.length / 2

        sOnlyLetters.forEachIndexed { index, c ->
            if (index > checkUntil) return true
            if (c != sOnlyLetters[sOnlyLetters.length - 1 - index]) return false
        }
        return true
    }

    // Found a pointer suggestion online the rest is self coded
    // This is more memory efficient and according to the leetcode tests has a better runtime.
    fun isPalindrom2(s: String): Boolean {
        var leftPointer = 0
        var leftPointerIsAlphanumeric = true
        var leftPointerChar: Char

        var rightPointer = s.length - 1
        var rightPointerIsAlphanumeric = true
        var righPointerChar: Char

        while (leftPointer < rightPointer) {
            leftPointerChar = s[leftPointer]
            righPointerChar = s[rightPointer]

            if (!leftPointerChar.isLetterOrDigit()) leftPointerIsAlphanumeric = false

            if (!righPointerChar.isLetterOrDigit()) rightPointerIsAlphanumeric = false

            if (leftPointerIsAlphanumeric && rightPointerIsAlphanumeric) {
                if (leftPointerChar.lowercase() != righPointerChar.lowercase()) return false
                leftPointer++
                rightPointer--
            } else {
                if (leftPointerIsAlphanumeric) rightPointer--
                if (rightPointerIsAlphanumeric) leftPointer++
                if (!rightPointerIsAlphanumeric && !leftPointerIsAlphanumeric) {
                    leftPointer++
                    rightPointer--
                }
            }

            leftPointerIsAlphanumeric = true
            rightPointerIsAlphanumeric = true
        }

        return true
    }

    // This is an refined version of solution 2, which is more perfomand and more memory efficient than solution 1 and ok'ish on readibility
    fun isPalindrom3(s: String): Boolean {
        var leftPointer = 0
        var rightPointer = s.length - 1 // Used for the index of the string s (index starting at 0)

        while (leftPointer < rightPointer) {
            if (!s[leftPointer].isLetterOrDigit()) {
                leftPointer++
                continue
            }

            if (!s[rightPointer].isLetterOrDigit()) {
                rightPointer--
                continue
            }

            if (s[leftPointer].lowercase() != s[rightPointer].lowercase()) return false

            leftPointer++
            rightPointer--
        }

        return true
    }
}