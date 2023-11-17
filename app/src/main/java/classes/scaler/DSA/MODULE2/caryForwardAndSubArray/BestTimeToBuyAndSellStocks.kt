package classes.scaler.DSA.MODULE2.caryForwardAndSubArray

/*
Problem Description
Say you have an array, A, for which the ith element is the price of a given stock on day i.
If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
design an algorithm to find the maximum profit.
Return the maximum possible profit.

Input Format
The first and the only argument is an array of integers, A.

Output Format
Return an integer, representing the maximum possible profit.
* */

fun main() {
    //maxProfit is 4, buying at 1 and sell at 5
    //check minimum value and also calculate max profit with current element,
    //and check whole array like this, you'll get the maximum profit
//    val A = intArrayOf(1,2)
    val A = intArrayOf(7, 1, 5, 3, 6, 4)
    println(maxProfit(A))
}

fun maxProfit(prices: IntArray): Int {
    if (prices.isEmpty())
        return 0
    var boughtAt = prices[0]//Lets assume min buying at 1st day
    var soldAt = boughtAt

    var maxProfit =
        (soldAt - boughtAt) //Lets assume maxProfit is 0 at day 1 because => (soldAt - buyingAt) on same day 1

    for (i in prices.indices) {
        if (prices[i] < boughtAt)//Change buying price if finds more cheaper
            boughtAt = prices[i]

        //maxProfit = maxOf(maxProfit, prices[i] - boughtAt)
        //Update maxProfit if finds more profit then (currentPrice - buyingAtPrice)
        if (maxProfit < (prices[i] - boughtAt)) {
            soldAt = prices[i]
            maxProfit = (soldAt - boughtAt)
        }
    }
    println("Bought at $boughtAt and Sold at $soldAt")
    return maxProfit
}
//If can multi transactions
//https://www.youtube.com/watch?v=K8iHi8AW1ls&list=PLEJXowNB4kPwCPVjDv6KsAsThtDOCQUok&index=5
//Using tree of 3 nodes