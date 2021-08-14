class Solution {
    
    
    
    public void makeAlive(int[][] board, int[][] ans, int i, int j){
                int rows = board.length;
        int cols = board[0].length;
        
        int liveNbrs = 0;
        
        int[] dx = {-1, 0, 1, 0, -1 , 1 ,1, -1};
        int[] dy = {0, -1, 0, 1,  -1, 1 , -1, 1};
        
        for(int k=0; k<8; k++){
            int nbrX = i+dx[k];
            int nbrY = j+dy[k];
            
            if(nbrX<0 || nbrX>=rows || nbrY<0 || nbrY>=cols){
                continue;
                
            }
            
            if(ans[nbrX][nbrY]==1){
                liveNbrs++;
            }
            
        }
        
        if(liveNbrs==3){
            board[i][j]=1;
        }
        else{
            board[i][j]=0;
        }
        
        
        
    }
    
    
    public void canLive(int[][] board, int[][] ans, int i, int j){
        
          int rows = board.length;
        int cols = board[0].length;
        
        int liveNbrs = 0;
        
        int[] dx = {-1, 0, 1, 0, -1 , 1 ,1, -1};
        int[] dy = {0, -1, 0, 1,  -1, 1 , -1, 1};
        
        for(int k=0; k<8; k++){
            int nbrX = i+dx[k];
            int nbrY = j+dy[k];
            
            if(nbrX<0 || nbrX>=rows || nbrY<0 || nbrY>=cols){
                continue;
                
            }
            
            if(ans[nbrX][nbrY]==1){
                liveNbrs++;
            }
            
        }
        if(liveNbrs<2){
            board[i][j]=0;
        }
        else if(liveNbrs==2 || liveNbrs==3){
            board[i][j]=1;
        }
        else {
            board[i][j]=0;
        }
        
        
        
    }
    
    
    
    
    
    public void gameOfLife(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        
        int[][] ans = new int[rows][cols];
        
                for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                
                ans[i][j] = board[i][j];
            }
        }
        
        
        for(int i=0; i<rows; i++){
            for(int j=0; j<cols; j++){
                if(ans[i][j]==0){
                    makeAlive(board, ans, i, j);
                }
                else{
                    canLive(board, ans, i, j);
                }
            }
        }
        
    
        
    }
}
