class Solution {
    public int maxProfit(int[] prices) {
        int min = prices[0];
        int profit = 0;
        int maxProfit = 0;
        for(int i = 0; i<prices.length; i++){
            if(prices[i]<=min)min=prices[i];
            else {
                profit = prices[i] - min;
                maxProfit = Math.max(profit, maxProfit);
            }
            
        }
        return maxProfit;
    }
}
//https://takeuforward.org/data-structure/stock-buy-and-sell/