class Solution {
public:
    int lengthOfLIS(vector<int>& nums) {
        int len = nums.size();
        
        int lis[len];
        for(int i=0; i<len; i++){
             lis[i] = 1;
            
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] && lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;
                }
            }
        }
        
        int mx = 0;
        
        for(int i=0; i<len; i++){
            mx = max(lis[i], mx);
        }
        
        return mx;
        
    }
};