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
}