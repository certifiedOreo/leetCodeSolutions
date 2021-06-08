class Solution {
public:
    int minPathSum(vector<vector<int>>& grid) {
        
        int m = grid.size();
        int n = grid[0].size();
        
        int dpTable[m][n];
        
        
            dpTable[0][0] = grid[0][0];
        for(int i=1; i<m; i++){
            
            dpTable[i][0] = dpTable[i-1][0]+ grid[i][0];
            
        }
        
           for(int i=1; i<n; i++){
            
            dpTable[0][i] = dpTable[0][i-1]+ grid[0][i];
            
        }
        
        
        
        for(int i=1; i<m; i++){
            for(int j=1; j<n; j++){
                dpTable[i][j] = grid[i][j]+ min(dpTable[i-1][j], dpTable[i][j-1]);
            }
        }
        
        return dpTable[m-1][n-1];
        
    }
};