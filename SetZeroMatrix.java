class Solution {
    public void setZeroes(int[][] matrix) {
        
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rowSet = new HashSet<>();       
        Set<Integer> colSet = new HashSet<>();

        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(matrix[i][j]==0){
                    rowSet.add(i);
                    colSet.add(j);
                }
            }
        }
        
         for(int i=0; i<r; i++){
            for(int j=0; j<c; j++){
                if(rowSet.contains(i) || colSet.contains(j)){
                    matrix[i][j] = 0;

                }
            }
        }
        
 
        
        
        
    }
}
