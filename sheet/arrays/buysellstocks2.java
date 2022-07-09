class Solution {
    public int maxProfit(int[] prices) {
        int profit = 0;
        int sellDate = prices[0];
        int buyDate = prices[0];
        
        for(int i = 1; i<prices.length; i++){
            if(prices[i]>=sellDate){
                sellDate = prices[i];
                
            }else{
                profit += sellDate-buyDate;
                buyDate = prices[i];
                sellDate = prices[i];
            }
        }
        profit += sellDate-buyDate; // this is to settle the last profit
        return profit;
    }
}