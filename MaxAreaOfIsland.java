class MaxAreaOfIsland {
    
   static  int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    
    
    public static boolean isSafe(int[][] grid, int i, int j, boolean[][] isVisited){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length|| grid[i][j]==0 || isVisited[i][j]==true){
            return false;
        }
        
        return true;
    }
    
    
    public static void dfs(int[][] grid, int i, int j, boolean[][] isVisited, int[] area){
        isVisited[i][j] = true;
        area[0]++;
        
        for(int k=0; k<4; k++){
            int x = i+dx[k];
            int y = j+dy[k];
            
            if(isSafe(grid, x, y, isVisited)){
                dfs(grid, x, y, isVisited, area);
            }
        }
    }
    
    
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxArea = 0;
        
        boolean[][] isVisited = new boolean[m][n];
        
for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                isVisited[r][c] = false;
                    }
                }
        
        
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c]==1){
                    if(isVisited[r][c]==false){
                        int[] area = new int[1];
                        area[0] = 0;
                        
                        dfs(grid, r, c, isVisited, area);
                            maxArea = Math.max(maxArea, area[0]);
                        
                    }
                }
            }
        }
        
        return maxArea;
        
    }
}
