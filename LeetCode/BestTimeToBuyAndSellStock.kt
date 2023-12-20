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

    // Next solution is a not-optimized version that always gets the highest number,
    // then checks the profit from the smallest number before that biggest number and calculates the profit from those two.
    // Afterward, we repeat the process for the sub-list after the initial biggest number.
    fun maxProfit3(prices: IntArray): Int {
        var currentMaxProfit = 0
        var higherstRemainingNumber = 0
        var higherstRemainingNumberIndex = 0
        var lowestNumberInSubList: Int? = null

        var remainingList = prices.toList()

        while (remainingList.size > 1) {
            for ((index, item) in remainingList.withIndex()) {
                if (item > higherstRemainingNumber) {
                    higherstRemainingNumber = item
                    higherstRemainingNumberIndex = index
                }
            }

            for (item in remainingList.dropLast(remainingList.size - higherstRemainingNumberIndex)) {
                if (item < (lowestNumberInSubList ?: higherstRemainingNumber)) {
                    lowestNumberInSubList = item
                }
            }

            if ((higherstRemainingNumber - (lowestNumberInSubList ?: higherstRemainingNumber)) > currentMaxProfit) {
                currentMaxProfit = higherstRemainingNumber - lowestNumberInSubList!!
            }

            remainingList = remainingList.drop(higherstRemainingNumberIndex + 1)

            // Reset numbers for the next iteration
            lowestNumberInSubList = higherstRemainingNumber
            higherstRemainingNumber = 0
            higherstRemainingNumberIndex = 0
        }

        return currentMaxProfit
    }

    // Same as solution 3 but saving one iteration if the highest number is smaller than the maximum profit
    fun maxProfit4(prices: IntArray): Int {
        var currentMaxProfit = 0
        var higherstRemainingNumber = 0
        var higherstRemainingNumberIndex = 0
        var lowestNumberInSubList: Int? = null

        var remainingList = prices.toList()

        while (remainingList.size > 1) {
            for ((index, item) in remainingList.withIndex()) {
                if (item > higherstRemainingNumber) {
                    higherstRemainingNumber = item
                    higherstRemainingNumberIndex = index
                }
            }
            if (currentMaxProfit < higherstRemainingNumber) {
                for (item in remainingList.dropLast(remainingList.size - higherstRemainingNumberIndex)) {
                    if (item < (lowestNumberInSubList ?: higherstRemainingNumber)) {
                        lowestNumberInSubList = item
                    }
                }

                if ((higherstRemainingNumber - (lowestNumberInSubList ?: higherstRemainingNumber)) > currentMaxProfit) {
                    currentMaxProfit = higherstRemainingNumber - lowestNumberInSubList!!
                }
            }

            remainingList = remainingList.drop(higherstRemainingNumberIndex + 1)

            // Reset numbers for the next iteration
            lowestNumberInSubList = higherstRemainingNumber
            higherstRemainingNumber = 0
            higherstRemainingNumberIndex = 0
        }

        return currentMaxProfit
    }

    // Turns out this can be done in one with just 2 variables :D
    fun maxProfit5(prices: IntArray): Int {
        var currentMaxProfit = 0
        var minFoundPrice = prices[0]

        prices.forEach {
            if (minFoundPrice > it) minFoundPrice = it
            if (it - minFoundPrice > currentMaxProfit) currentMaxProfit = it - minFoundPrice
        }

        return currentMaxProfit
    }
}
