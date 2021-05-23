#include <iostream>
#include <vector>
using namespace std;





class Solution {
public:
    int canCompleteCircuit(vector<int>& gas, vector<int>& cost){
        
        int totalGas = 0;  
        int currGas = 0;
        int start = 0;
        
        for(int i=0; i< gas.size(); i++ ){
            currGas+=gas[i] - cost[i];
            totalGas+=gas[i] - cost[i];
            if(currGas<0){   //if not sufficient gas to reach next station then reset the currGas and change start point 
                start = i+1;
                currGas = 0;
            }
        }
            
        if(totalGas<0){   //if >=0 surplus gas remained after checking all stations then we can reach the start point
            return -1;
        }
    return start;
        
    }
};