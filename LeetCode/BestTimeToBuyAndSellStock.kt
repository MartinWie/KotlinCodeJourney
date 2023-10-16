class BestTimeToBuyAndSellStock {

    // First version jusr stupid brute force.
    fun maxProfit(prices: IntArray): Int {
        var currentMaxProfit = 0

        for ((index, item) in prices.withIndex()) {
            val currentList = prices.drop(index + 1)
            currentList.forEach {
                val tempProfit = it - item
                if (tempProfit > currentMaxProfit) currentMaxProfit = tempProfit
            }
        }

        return currentMaxProfit
    }

    // Slightly better solution only trying the numbers that could be better
    fun maxProfit2(prices: IntArray): Int {
        var currentMaxProfit = 0
        var currentLowestNumber: Int? = null

        for ((index, item) in prices.withIndex()) {
            if (item >= (currentLowestNumber ?: (item + 1))) continue
            val currentList = prices.drop(index + 1)
            currentList.forEach {
                val tempProfit = it - item
                if (tempProfit > currentMaxProfit) {
                    currentMaxProfit = tempProfit
                    currentLowestNumber = item
                }
            }
        }

        return currentMaxProfit
    }

    // Test if multithreading for searching the sublists brings any benefit here(Good opportunity to practice multi Threading a bti ;) )
}
