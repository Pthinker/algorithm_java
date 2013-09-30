Say you have an array for which the ith element is the price of a given stock 
on day i.

Design an algorithm to find the maximum profit. You may complete as many 
transactions as you like (ie, buy one and sell one share of the stock multiple 
times). However, you may not engage in multiple transactions at the same time (ie, 
you must sell the stock before you buy again).



public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length<2)
            return 0;
        
        int max = 0;    
        int prev = prices[0];
        for(int i=1; i<prices.length; i++) {
            if(prices[i]>prev) {
                max += prices[i] - prev;
            }
            prev = prices[i];
        }
        
        return max;
    }
}

////////////////////////////////////////////////////////////////////////////////

public class Solution {
    public int maxProfit(int[] prices) {
        if(prices==null || prices.length==0) return 0;

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            int d = prices[i] - prices[i - 1];
            if (d > 0) {
                profit += d;
            }
        }
        return profit;
    }
}

