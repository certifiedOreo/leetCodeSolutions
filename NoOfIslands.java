
class NoOfIslands {
    
    static int[] dx = {-1, 0,1 ,0};
    static int[] dy = {0, 1, 0, -1};
    
    
    public static boolean isSafe(char[][] grid, int x, int y, boolean[][] isVisited){
        if(x<0 || y<0 || x>= grid.length || y>=grid[0].length || grid[x][y]=='0' || isVisited[x][y]==true){
            return false;
        }
        return true;
    }
    
    
    public static void dfs(char[][] grid, int i, int j, boolean[][] isVisited){
        isVisited[i][j]= true;
        
        
        
        
        for(int k=0; k<4; k++){
            int x= i+dx[k];
            int y= j+dy[k];
            
            if(isSafe(grid, x, y, isVisited)){
                dfs(grid, x, y, isVisited);
            }
            
        }
    }
    public int numIslands(char[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        
        int ans = 0;
        
        boolean[][] isVisited = new boolean[m][n];
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                isVisited[r][c] = false;
            }
        }
        
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c]=='1' && isVisited[r][c] ==false){
                    ans++;
                    dfs(grid, r, c, isVisited);
                    
                    
                }
            }
        }
        
        return ans;
        
    }
}
