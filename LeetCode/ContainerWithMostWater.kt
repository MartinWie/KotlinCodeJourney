import kotlin.math.abs

class ContainerWithMostWater {
    fun maxArea(height: IntArray): Int {
        if (height.size <= 1) return 0
        var maxArea = 0
        for (outerIndex in height.indices) {
            for (innerIndex in height.indices) {
                val currentArea = minOf(height[outerIndex], height[innerIndex]) * abs(innerIndex-outerIndex)
                if ( currentArea > maxArea) maxArea = currentArea
            }
        }
        return maxArea
    }
}