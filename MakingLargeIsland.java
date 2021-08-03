class MakingLargeIsland {
    
    static int[] dx = { -1, 0, 1, 0};
    static int[] dy = { 0, 1, 0, -1};
    
    public static boolean isSafe(int[][] grid, int i, int j){
        if(i<0 || j< 0 || i>=grid.length || j>= grid[0].length || grid[i][j]==0 ){
            return false;
        }
        return true;
    }
    
    
    public static int dfs(int[][] grid, int r, int c,  int[][] isVisited, int index){
        isVisited[r][c] = index;
        int area = 1;
       
        for(int i=0; i<4; i++){
            int x = r+dx[i];
            int y = c+dy[i];
            
            if(isSafe(grid, x, y) && isVisited[x][y]<=0 ){
                area+=dfs(grid, x, y, isVisited, index);
            }
        }
        
        return area;
        
        
        
        
        
    }
    
    
    public int largestIsland(int[][] grid) {
        
        int m = grid.length;
        int n = grid[0].length;
        int ans = 0;
        
        int[][] isVisited = new int[m][n];
        
        HashMap<Integer, Integer> areaMap = new HashMap<>();
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                isVisited[r][c] = 0;
            }
        }
        
        
        int isLandIndx = 1;
         for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                if(grid[r][c]==1 && isVisited[r][c]<=0){
                    
                    int area = dfs(grid, r, c, isVisited, isLandIndx);
                    areaMap.put(isLandIndx, area);
                    isLandIndx++;
                    
                }
            }
        }
        
        boolean flag = false;
        
        for(int r=0; r<m; r++){
            for(int c=0; c<n; c++){
                int area = 0;
                if(grid[r][c]==0){
                    flag = true;
                    Set<Integer> isLandIndexSet = new HashSet<>();
                    
                    
                    for(int i=0; i<4; i++){
                        int nbrX = r+dx[i];
                        int nbrY = c+dy[i];
                        
                        
                        if(isSafe(grid, nbrX, nbrY)){
                            
                             isLandIndexSet.add(isVisited[nbrX][nbrY]);
                            
                        }
                    }
                    
                    
                    for(int islandIdx : isLandIndexSet){
                        area +=  areaMap.getOrDefault(islandIdx, 0);
                    
                    
                    
                } 
                    ans = Math.max(ans, area+1);
            }
               
                
        }
        
 }
        
//         for(Map.Entry mapElement : areaMap.entrySet()){
            
//             System.out.println(mapElement.getKey() + ": "+ mapElement.getValue());
            
            
//         }
        
        if(!flag){
            return areaMap.get(1);
        }
        
        return ans;
}
}
