#include <iostream>
#include <vector>
#include <queue>
using namespace std;


    int lastStoneWeight(vector<int>& stones) {
        priority_queue<int, vector<int> > heap;
        
        int n = stones.size();
        
        for(int i=0; i< stones.size(); i++){
            heap.push(stones[i]);
        }
        
        while( n>1){
            int y = heap.top();
            heap.pop();
            int x = heap.top();
            heap.pop();
            n-=2;
            
            if(x!=y){
                heap.push(y-x);
                n+=1;
            }
            
        }
        int ans = -1;
        if(n==0){
            ans = 0;
        }
        if(n==1){
            ans =  heap.top();
        }
        
        return ans;
        
    }

    int main(){
        vector<int> arr{7, 3, 2};
        cout<<lastStoneWeight(arr)<<endl;

        return 0;
    }