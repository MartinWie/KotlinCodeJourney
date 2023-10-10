class TwoSum {
    // First quick and dirty brute force
    fun twoSum(nums: IntArray, target: Int): IntArray {
        for ((index, num) in nums.withIndex()) {
            var firstIndex = index
            for ((compareIndex, compareNum) in nums.drop(index + 1).withIndex()) {
                if (num + compareNum == target) return intArrayOf(firstIndex, compareIndex + index + 1)
            }
        }
        return intArrayOf(-1, -1)
    }

    // After that try implementing with hashmap (target = a+b, we have a and t so check in hashmap for b)
    fun twoSum2(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, List<Int>>()

        nums.forEachIndexed { index: Int, num: Int ->
            if (hashMap[num] == null) {
                hashMap[num] = listOf(index)
            } else {
                // If a number appears at multiple indexes we store all of them
                hashMap[num] = hashMap[num]!! + listOf(index)
            }
        }

        var currentCounterPart: Int? // Index of the value we need to add to the current number to get to the target.
        var counterpartIndex: Int? // The number that we need to have to get to the target value(value is used as the index)

        for ((index, num) in nums.withIndex()) {
            counterpartIndex = target - num

            if (hashMap[counterpartIndex] != null) {
                currentCounterPart = if (num == counterpartIndex && hashMap[counterpartIndex]!!.size <= 1) {
                    null
                } else {
                    hashMap[counterpartIndex]?.last()
                }
            } else {
                currentCounterPart = null
            }

            if (currentCounterPart != null) return intArrayOf(index, currentCounterPart)
        }

        return intArrayOf(-1, -1)
    }

    // Lets get that cleaned up and optimise, to return immediately when finding a douplicate
    // Trick here: While filling the hashmap chekcing for the desired number (t = a + b so -> t - a = b)
    fun twoSum3(nums: IntArray, target: Int): IntArray {
        val hashMap = HashMap<Int, Int>()

        nums.forEachIndexed { index: Int, num: Int ->
            val counterPartValue = target - num
            val counterPartIndex = hashMap[counterPartValue]

            if (counterPartIndex != null) return intArrayOf(counterPartIndex, index)

            hashMap[num] = index
        }
        return intArrayOf(-1, -1)
    }
}