class Solution {
public:
    int uniquePathsWithObstacles(vector<vector<int>>& obstacleGrid) {
        
        
        int totalRows = obstacleGrid.size();
        int totalCols = obstacleGrid[0].size();
        
        int dpTable[totalRows][totalCols];
        
        
        int obsFound = false;
        
        for(int row=0; row<totalRows; row++){
            if(obsFound|| obstacleGrid[row][0]==1){
                obsFound= true;   //obstacle found 
                dpTable[row][0] = 0;
            }
            
            else{
                   dpTable[row][0] = 1;
            }
            
        }
        
     obsFound = false;   
        
         for(int col=0; col<totalCols; col++){
            if(obsFound || obstacleGrid[0][col]==1){
             obsFound= true;   //obstacle found 
                dpTable[0][col] = 0;
            }
            
            else{
                   dpTable[0][col] = 1;
            }
            
        }
        
        
        
        for(int i=1; i<totalRows; i++){
            for(int j=1; j<totalCols; j++){
                if(obstacleGrid[i][j]==1){
                                    dpTable[i][j] = 0;
                    
                }
                else{
                                    dpTable[i][j] =   dpTable[i-1][j] + dpTable[i][j-1];
                }
            }
        }
        
        
        return dpTable[totalRows-1][totalCols-1];
        
      
        
    }
};

