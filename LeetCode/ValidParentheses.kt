class ValidParentheses {
    fun isValid(s: String): Boolean {
        var lastRound: Char? = null
        var lastSquare: Char? = null
        var lastCurly: Char? = null

        for (char in s) {
            when (char) {
                '(' -> if (lastRound == null) lastRound = char else return false
                ')' -> if (lastRound == '(' && lastSquare == null && lastCurly == null) lastRound = null else return false

                '[' -> if (lastSquare == null) lastSquare = char else return false
                ']' -> if (lastSquare == '[' && lastRound == null && lastCurly == null) lastSquare = null else return false

                '{' -> if (lastCurly == null) lastCurly = char else return false
                '}' -> if (lastCurly == '{' && lastRound == null && lastSquare == null) lastCurly = null else return false
            }
        }

        return true
    }

    // Found a way to fix the former issue, the trick was actually a last in first out stack.
    // Here done with mutableList there is probably a better was to do this in kotlin, I will check this tomorrow.
    fun isValid2(s: String): Boolean {
        val list = mutableListOf<Char>()

        s.forEach {
            val lastInChar = list.lastOrNull()
            when (it) {
                '(', '[', '{' -> list.add(it)
                ')' -> if (lastInChar == '(') list.removeLast() else return false
                ']' -> if (lastInChar == '[') list.removeLast() else return false
                '}' -> if (lastInChar == '{') list.removeLast() else return false
            }
        }

        return list.isEmpty()
    }
}
