#include <iostream>
#include <vector>
using namespace std;

class Solution {
public:
    int pivotIndex(vector<int>& nums) {
        int n = nums.size();
        vector<int> cumSum;  //arr for cumulative sum
        cumSum.push_back(nums[0]); 
        
        for(int i=1; i<n; i++){
            cumSum.push_back(cumSum[i-1]+nums[i]);
        }
        
        if(n==1){
            return 0;
        }
        
        if(n==2){
            return -1;
        }
        
        for(int i=0; i<n; i++){
            int leftSum = -1;
            int rightSum = -1;
            
            if(i-1<0){
                leftSum = 0;
            }
            else{
                leftSum = cumSum[i-1];
            }
            
            
            if(i+1==n){
                rightSum = 0;
            }
            else{
                rightSum = cumSum[n-1]-cumSum[i];
            }
            
            if(leftSum==rightSum){
                return i;
            }
            
            
        }
        
        return -1;
        
        
        
    }
};