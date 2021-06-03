class Solution {
public:
    int findNumberOfLIS(vector<int>& nums) {
        
  int len = nums.size();
        
        int lis[len];
        int count[len];
        lis[0]=1;
        for(int i=0; i<len; i++){
             lis[i] = 1;
            count[i]=1;
            
            for(int j=0; j<i; j++){
                if(nums[i]>nums[j] ){
                    if(lis[i]<lis[j]+1){
                    lis[i]=lis[j]+1;     //found lis of greater length
                    count[i] = count[j];   //but count if this new lis will be same as of count[j]
                }
                    else if(lis[i] ==lis[j]+1){ //this is the special case, if lis of length lis[i]+1 is already equal to lis[j] then length won't increase but count will be added
                        count[i]+=count[j];
                    }
                }
            }
        }
        
        int ans = 0;
        int maxLis=1;
        
        //find the lis of maximum length
        
      for(int i=0; i<len; i++){
          maxLis = max(maxLis, lis[i]);
      }
        
        
        //count all the lis of length maxLis
       for(int i=0; i<len;i++){
           if(lis[i]==maxLis){
               ans+=count[i];
           }
           
           
       }
        
        return ans;
        
       
        
        
        
    }
};