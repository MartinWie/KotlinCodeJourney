class ThreeSum {
    fun threeSum(nums: IntArray): List<List<Int>> {
        val targetSum = 0
        val resultsList = mutableListOf<List<Int>>()
        val numsList = nums.toMutableList()

        for (outerNum in numsList) {
            for (midNum in numsList.minus(outerNum)) {
                for (innerNum in numsList.minus(outerNum).minus(midNum)) {
                    if (innerNum + midNum + outerNum == targetSum) {
                        resultsList.add(listOf(innerNum, midNum, outerNum).sorted())
                    }
                }
            }
        }
        return resultsList.distinct()
    }

    fun threeSum2(nums: IntArray): List<List<Int>> {
        val resultList = mutableListOf<List<Int>>()

        nums.sort()

        for (index in nums.indices) {
            if (index > 0 && nums[index] == nums[index - 1]) continue

            var leftPointer = index + 1
            var rightPointer = nums.size - 1

            while (leftPointer < rightPointer) {
                val sum = nums[index] + nums[leftPointer] + nums[rightPointer]

                when {
                    sum == 0 -> {
                        resultList.add(listOf(nums[index], nums[leftPointer], nums[rightPointer]))

                        leftPointer++
                        rightPointer--

                        while (leftPointer < rightPointer && nums[leftPointer] == nums[leftPointer - 1]) leftPointer++
                        while (leftPointer < rightPointer && nums[rightPointer] == nums[rightPointer + 1]) rightPointer--
                    }

                    sum < 0 -> {
                        leftPointer++
                    }

                    sum > 0 -> {
                        rightPointer--
                    }
                }
            }
        }

        return resultList
    }

    fun threeSum3(nums: IntArray): List<List<Int>> {
        nums.sort()

        val resultList = mutableListOf<List<Int>>()
        for (index in nums.indices) {
            // Avoid duplicate triplets
            if (index == 0 || nums[index] != nums[index - 1]) {
                twoSum(nums, index, -nums[index], resultList)
            }
        }

        return resultList
    }

    private fun twoSum(nums: IntArray, startIndex: Int, target: Int, resultList: MutableList<List<Int>>) {
        val seen = HashSet<Int>()

        for (i in startIndex + 1 until nums.size) {
            if (seen.contains(target - nums[i])) {
                val triplet = listOf(-target, target - nums[i], nums[i])
                // Add the triplet if it's not already in the list to avoid duplicates
                if (!resultList.contains(triplet)) {
                    resultList.add(triplet)
                }
            }
            seen.add(nums[i])
        }
    }
}
