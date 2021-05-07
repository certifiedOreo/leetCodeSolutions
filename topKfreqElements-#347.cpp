#include <iostream>
#include <queue>
#include <unordered_map>
using namespace std;






class Solution {
    
    //our maxHeap will have elements of type node
    struct node{
        int value;
        int freq;
        
        node(int v, int f){
            value = v;
            freq = f;
        }
    };
    
    struct myComparator{
        bool operator()(node const& n1, node const& n2){
            return n1.freq < n2.freq;
        }
    };
    
    
public:
    vector<int> topKFrequent(vector<int>& nums, int k) {
        unordered_map<int, int> myMap;   //map to store freq. of each number
        vector<int> ans;  //vector to store final answer
        
        //storing freq of number in the map
        for(int num : nums){
            if(myMap.find(num) == myMap.end()){
                myMap[num] = 1;
     }
            else{
                myMap[num]++;
            }         
    }
 
    // Traverse the map, make a node for each with each key, value and push in heap
        priority_queue<node, vector<node>, myComparator > myHeap;
         for (auto& it : myMap) {
                myHeap.push( node(it.first, it.second) );    
    }
        
        
        //pop top k elements from the heap
        for(int i=0; i<k; i++){
            node max = myHeap.top();
            myHeap.pop();
            ans.push_back( max.value);
        }
        
        return ans;
}
};