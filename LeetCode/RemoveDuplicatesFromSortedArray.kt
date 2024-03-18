class RemoveDuplicatesFromSortedArray {
    private fun solve(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        var i = 0
        for (j in 1..nums.lastIndex) {
            if (nums[i] != nums[j]) {
                i++
                nums[i] = nums[j]
            }
        }

        return i + 1
    }
}