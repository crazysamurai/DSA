class Solution {
    public boolean isValidSudoku(char[][] board) {
        if(board.length==0 || board==null) return false;
        
        for(int i = 0; i<board.length; i++){
            for(int j= 0; j<board[0].length; j++){
         
                if(board[i][j]!='.'){
                    char c = board[i][j];
                    board[i][j]='.';//remove the char from it's spot so that the isvalid function can check forother occurances of the same
                    if(isValid(board, i, j, c)==false) return false;
                    board[i][j]=c;
                }
                
            }
        }
        return true;
    }
    
    public boolean isValid(char [][] board, int row, int col, char c){
        for(int i = 0; i<9; i++){
            if(board[row][i]==c) return false;
            if(board[i][col]==c) return false;
            if(board[3*(row/3)+(i/3)][3*(col/3)+(i%3)] == c) return false;
        }
        return true;
    }
}