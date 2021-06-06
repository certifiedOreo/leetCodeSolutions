class Solution {
public:
    int longestConsecutive(vector<int>& nums) {
   unordered_set<int> mySet; int res = 0;
        if(nums.size()==1){
            return 1;
        }
        
        for(int num : nums){
           mySet.insert(num);
        }
        
                for(int num : nums){
                    if(mySet.find(num)!=mySet.end()){
                       mySet.erase(num);
                        int prev = num-1;
                        int next = num+1;
                        while(mySet.find(prev)!=mySet.end()){
                            mySet.erase(prev);
                            prev--;
                        }
                        
                        while(mySet.find(next)!=mySet.end()){
                         mySet.erase(next);
                            next++;
                        }
                        res = max(res, next-prev-1);
                    }
                    
                    
                    
                    
            }
        
        return res;
        
        
        
    }
};