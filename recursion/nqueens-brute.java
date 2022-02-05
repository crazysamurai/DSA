class Solution {
    public List<List<String>> solveNQueens(int n) {
        char [][] board = new char [n][n];
        for(int i = 0; i<n; i++){
            for(int j = 0; j<n; j++){
                board[i][j] = '.';
            }
        }
        
        List<List<String>> res = new ArrayList<List<String>>();
        fun(board, res, 0);
        System.out.println(res.size());
                return res;
    }
    
    private boolean test(int row, int col,char[][] board){
        int duprow = row;
        int dupcol = col;
        
        while(row>=0 && col>=0){
            if(board[row][col]=='Q') return false;
            row--;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        while(col>=0){
            if(board[row][col]=='Q') return false;
            col--;
        }
        
        row = duprow;
        col = dupcol;
        while(col>=0 && row<board.length){
            if(board[row][col]=='Q')return false;
            col--;
            row++;
        }
        
        return true;
        
    }
    
    public void fun(char [][] board, List<List<String>> res, int col){
        if(col==board.length){
            res.add(construct(board));
            return;
        }
        
        for(int row = 0; row<board.length; row++){
            if(test(row, col, board)){
                board[row][col] = 'Q';
                fun(board, res, col+1);
                board[row][col] = '.';
            }
        }
    }
    
    public List<String> construct(char [][] board){
        List<String> res= new LinkedList<String>();
        for(int i = 0; i<board.length; i++){
            String S = new String(board[i]);
            res.add(S);
        }
        return res;
    }
}