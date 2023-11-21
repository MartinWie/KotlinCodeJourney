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
}
