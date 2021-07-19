class BestTimeToBuy {
    

    
    
   
    public int maxProfit(int[] prices) {
        int minPrice=prices[0];
        int maxProf = 0;
        int n= prices.length;
        
        
        for( int i=0; i<n; i++){
            if(prices[i]<minPrice){
                minPrice = prices[i];
            }
            else{
                if( prices[i] - minPrice > maxProf){
                    maxProf = prices[i] - minPrice;
                }
            }
            
        }
        
        return maxProf;
        
                        
}
  
    
}
                           
                           
                           
                           
                           
                           
