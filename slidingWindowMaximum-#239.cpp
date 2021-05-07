#include <iostream>
#include <queue>
#include <vector>
using namespace std;




class Solution {
    
    struct node{
        int val;
        int ind;
        
        node (int v, int i){
            val = v;
            ind = i;
        }
    };
    
    struct myComparator{
        bool operator()(node const& n1, node const& n2){
            return n1.val<n2.val;
        }
    };
    
public:
    vector<int> maxSlidingWindow(vector<int>& nums, int k) {
        vector<int> ans;
        
        
        priority_queue<node, vector<node>, myComparator > maxHeap;
        
         for(int i=0;i<nums.size();++i)
        {
            while(!maxHeap.empty() and maxHeap.top().ind<=(i-k)){  //Pop the root (max_element),if it is out of sliding window
               maxHeap.pop();
            }
            maxHeap.push(node(nums[i],i));    //Push current element (along with its index) into the heap
            if(i>=k-1) {     //Store max in the window if we have a valid window (based on size K)
                ans.push_back(maxHeap.top().val);       
        }
         }
        return ans;
    }
        
    
        
        
        
        
    
};