#include <iostream>
#include <vector>
using namespace std;


class Solution {
public:
    int firstUniqChar(string s) {
        vector<int> freqArr(26, 0);
        
        for(int i=0; i<s.length(); i++){
            freqArr[s.at(i)-'a']++;
        }
        
        char ans;
        
        for(int i=0; s[i]!='\0'; i++){
            if(freqArr[s[i]-'a']==1){
                 return i;
                
            }
        }
        return -1;
        
    }
};