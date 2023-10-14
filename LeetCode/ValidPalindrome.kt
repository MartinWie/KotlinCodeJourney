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
}