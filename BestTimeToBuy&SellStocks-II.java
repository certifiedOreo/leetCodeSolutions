class Solution {
    public int maxProfit(int[] prices) {
        
        int profit = 0;
        int n = prices.length;
        for(int i=1; i<n; i++){
          //valley-peak approach , sell only when moving from valley to peak
            if(prices[i]>prices[i-1]){
                profit += prices[i]-prices[i-1];
            }
        }
        
        return profit;
        
    }
}
