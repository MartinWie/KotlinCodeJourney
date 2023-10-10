class ContainsDuplicates {

    // Simple start solution using a set and comparing the sizes
    fun containsDuplicates(numbers: List<Int>): Boolean {
        val numbersSet = numbers.toSet()
        return numbersSet.size == numbers.size
    }

    // Next version, sorting and then going through the numbers, would only be a gain in efficiency if we can get rid of the sorting.
    fun containsDuplicates2(numbers: List<Int>): Boolean {
        var last: Int? = null
        for (number in numbers.sorted()) {
            if (last != null && last == number) return true
            last = number
        }
        return false
    }

    // Final version, not the most memory efficient, but very performant.
    // Instead of converting the whole list to a set and then checking, we do the check during the list -> set conversion
    // which makes it this more efficient for lists that contain douplicates.
    fun containsDuplicates3(numbers: List<Int>): Boolean {
        val hashSet = HashSet<Int>()
        for (num in numbers) {
            if (num in hashSet) return true
            hashSet.add(num)
        }
        return false
    }
}