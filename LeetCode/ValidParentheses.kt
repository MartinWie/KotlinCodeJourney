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

    // TODO: fix case "{[]}" -> true in next version
}
