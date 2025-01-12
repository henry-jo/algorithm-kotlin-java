package leetcode

import kotlin.math.max

class BestTimeBuySellStock_121 {
    fun maxProfit(prices: IntArray): Int {
        var profit = 0
        var buyPrice = prices.first()

        prices.forEach { dailyPrice ->
            if (dailyPrice < buyPrice) {
                buyPrice = dailyPrice
            }

            profit = max(profit, dailyPrice - buyPrice)
        }

        return profit
    }
}
