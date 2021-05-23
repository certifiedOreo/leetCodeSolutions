#include <iostream>
#include <unordered_map>
#include <stack>
using namespace std;


class Solution {
public:
    bool isValid(string s) {
         unordered_map<char, int> myMap;
        myMap['(']  = 0;
        myMap['{'] = 1;
        myMap['['] = 2;
        myMap[')'] = 0;
        myMap['}'] = 1;
        myMap[']'] = 2;
        stack<char> myStack;
        
        for(int i=0; i<s.length(); i++){
            
            if(s.at(i) == '(' || s.at(i) =='{' || s.at(i) =='['  ){
                myStack.push(s.at(i));
            }
            else if(!myStack.empty() && myMap[myStack.top()] == myMap[s.at(i)]){
                    myStack.pop();
                }
               
            else{
                return false;
            }
            
            
            
            
        }
        bool ans = false;
        
        if(myStack.empty()){
            ans = true;
        }
        return ans;
        
        
    }
};