class StoneGame {
    public boolean stoneGame(int[] piles) {
        
        boolean alex = true;
        int left = 0;
        int right = piles.length-1;
        int alexScore=0;
        int leeScore = 0;
        
        while(left<right){
            
            if(alex==true){
                if(piles[left]<piles[right]){
                    alexScore+=piles[left];
                    left++;
                    
                }
                else{
                    alexScore+= piles[right];
                    right--;
                }
                
            }
            
            else{
                                if(piles[left]<piles[right]){
                    leeScore+=piles[right];
                    right--;
                    
                }
                else{
                    leeScore+= piles[left];
                    left++;
                }
            }
            
            
            
            
        }
        
        return alexScore>leeScore;
                                                
    }
}
