class Solution {
    public void gameOfLife(int[][] board) {
        /*
            original    new     val
            0           0       0
            1           0       1
            0           1       2
            1           1       3
        */
        
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                int n = neighbors(board, i, j);
                System.out.println(n);
                if(board[i][j] == 1 && (n==2||n==3)){
                    board[i][j] = 3;
                }
                else if(board[i][j] == 0 && n==3){
                    board[i][j] = 2;
                }
            }
        }
        
        for(int i = 0; i<board.length; i++){
            for(int j =0; j<board[0].length; j++){
                if(board[i][j]==2 || board[i][j]==3) board[i][j]=1;
                else board[i][j] = 0;
            }
        }
        
    }
    
    public int dirs[][] = new int[][] {{0,1}, {1,0}, {-1,0}, {0,-1}, {-1,-1}, {-1,1}, {1,-1}, {1,1}};
    
    private int neighbors(int [][] board, int i, int j){
        int count = 0;
        
        for(int dir[] : dirs){
            int row = i+dir[0];
            int col = j+dir[1];
            if(row>=0 && col>=0 && row<board.length && col<board[0].length && ( board[row][col] == 3 || board[row][col] == 1)){
                count++;
            }
        }
        
        return count;
    }
    
}