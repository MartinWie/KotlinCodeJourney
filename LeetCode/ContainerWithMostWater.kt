import org.junit.Test
import kotlin.math.abs
import kotlin.test.assertEquals

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        if (height.size <= 1) return 0
        var maxArea = 0
        for (outerIndex in height.indices) {
            for (innerIndex in height.indices) {
                val currentArea = minOf(height[outerIndex], height[innerIndex]) * abs(innerIndex - outerIndex)
                if (currentArea > maxArea) maxArea = currentArea
            }
        }
        return maxArea
    }

    fun maxArea2(height: IntArray): Int {
        if (height.size <= 1) return 0
        var maxArea = 0
        var leftPointer = 0
        var rightPointer = height.size - 1
        while (leftPointer < rightPointer) {
            val currentArea = minOf(height[leftPointer], height[rightPointer]) * (rightPointer - leftPointer)
            if (currentArea > maxArea) maxArea = currentArea

            if (height[leftPointer] >= height[rightPointer]) rightPointer-- else leftPointer++
        }
        return maxArea
    }

    @Test
    fun test() {
        assertEquals(49, maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
        assertEquals(49, maxArea2(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }
}
