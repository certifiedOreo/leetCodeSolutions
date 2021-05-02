
#include <vector>
#include <iostream>
using namespace std;

class Solution {
public:
    int candy(vector<int>& ratings) {
        int n = ratings.size();
        
        int arr1[n];
        int arr2[n];
        for(int i=0; i< n; i++){
            arr1[i] = 1;
            arr2[i] = 1;
            
        }
        
        for(int i=1; i<n; i++){
            if(ratings[i]>ratings[i-1]){
                arr1[i]=arr1[i-1]+1;
            }
        }
        
        for(int i=n-2; i>=0; i--){
            if(ratings[i]>ratings[i+1]){
                arr2[i]=arr2[i+1]+1;
            }
        }
        
        int ans=0;
        for(int i=0; i<n; i++){
            ans+=max(arr1[i], arr2[i]);
        }
        
        return ans;
        
    }
};