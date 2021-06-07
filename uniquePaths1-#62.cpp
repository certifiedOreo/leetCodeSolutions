class Solution {
public:
    int uniquePaths(int m, int n) {
        int dpTable[m][n];
        
        
        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(i==0 || j==0){
                    dpTable[i][j]=1;
                }
                else{
                    dpTable[i][j] =  dpTable[i-1][j]+ dpTable[i][j-1];
                }
            }
        }
        
        return dpTable[m-1][n-1];
        
    }
};