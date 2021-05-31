class Solution {
public:
    int longestCommonSubsequence(string text1, string text2) {
        
        int n1 = text1.size();
        int n2 = text2.size();
        
        int dpTable[n1+1][n2+1];
        
        for(int row=0; row<=n1; row++){
            dpTable[row][0]=0;
        }
        
        for(int col=0; col<=n2; col++){
            dpTable[0][col]=0;
        }
        
        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                    if(text1[i-1]==text2[j-1]){   //if equal then select both characters
                dpTable[i][j] = 1+dpTable[i-1][j-1];     
            }
            else{
                    dpTable[i][j] = max(dpTable[i-1][j], dpTable[i][j-1]);  //take max of both the possiblities by selecting only char from only one string
                    
        }
        }
        }
        
    
        
        return dpTable[n1][n2];
        
    }
        
        
};