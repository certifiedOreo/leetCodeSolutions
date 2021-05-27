#include <iostream>
#include <vector>
using namespace std;

                /*----THE APPROACH-----
                        observation 1: each subset should have their sum as totalSum/2, this equal partition is only possible when totalSum is even
                        observaton 2: since each element can only be in 1 of 2 subsets
                        from observation 2 we can say if we find a subset of sum = totalSum/2 this is must that there is also another subset of sum=totalSum/2

                        hence our problem reduces to subset Sum problem with sum = totalSum/2 because here also we have choice
                        that each element is either in a first subset or in second and also each element can only be chosen once!

            
                */


class Solution {
public:
    bool canPartition(vector<int>& nums) {
        int sum=0;
        int n = nums.size();

        //totalSum of given array
        for(int i=0; i<nums.size(); i++){
            sum+=nums[i];
        }
        
        //if sum is odd then return false
        if(sum%2!=0){
            return false;
        }
       
            int dpTable[n+1][sum/2+1];


            //if sum is 0, then required is achievable by rejecting all elements
        for( int row=0; row<=n; row++){
            dpTable[row][0]=true;
        }
        
        //without any element, any sum can't be achieved
        for(int col=1; col<=sum/2; col++){
            dpTable[0][col] = false;
        }


        
        for(int ele=1; ele<=n; ele++){
            for(int sm=1; sm<=sum/2; sm++){
                if( nums[ele-1]> sm){   //reject case
                    dpTable[ele][sm] = dpTable[ele-1][sm];
                }
                else{   //reject || accept
                    dpTable[ele][sm] = dpTable[ele-1][sm] || dpTable[ele-1][sm-nums[ele-1]];
                }
                
            }
        }
        
       return dpTable[n][sum/2];
        
        
        
    }
};