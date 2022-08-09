class Solution {
    //dfs
    public boolean exist(char[][] board, String word) {
        for(int i = 0; i<board.length; i++){
            for(int j = 0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(solve(0, i, j, board, word)) return true;
                }
            }
        }
        return false;
    }
    
    private boolean solve(int idx, int i, int j, char [][] board, String s){
        if(idx==s.length()) return true;
        if(i<0 || j<0 || i>board.length-1 || j>board[0].length-1 || s.charAt(idx)!=board[i][j]) return false;
        
        board[i][j] = ' ';//changing the value so thata we don't use the same char twice
        
        if(solve(idx+1, i-1, j, board, s) ||
        solve(idx+1, i+1, j, board, s) ||
        solve(idx+1, i, j+1, board, s) ||
        solve(idx+1, i, j-1, board, s)){
            return true;
        }
        board[i][j] = s.charAt(idx);//backtracking
                
        return false;
    }
    
}