class Solution {
    public int findMaxLength(int[] nums) {
        
        for(int i=0; i<nums.length; i++){
            if(nums[i]==0){
                nums[i] = -1;
            }
        }
            
            
            HashMap<Integer, Integer> map = new HashMap<>();
            int currSum = 0;
            int ans=0;
            for(int i=0; i<nums.length; i++){
                currSum+=nums[i];
                
                if(currSum==0){
                    ans = Math.max(ans, i+1);
                }
                else if(map.containsKey(currSum)){
                    ans = Math.max(ans, i-map.get(currSum));
                }
                else{
                    map.put(currSum, i);
                }
                
            }
        
        return ans;
            
        
        
    }
}
