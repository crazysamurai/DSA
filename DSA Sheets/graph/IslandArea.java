class Solution {
    public int maxAreaOfIsland(int[][] grid) {
      int rows = grid.length;
        int cols = grid[0].length;
        int max = 0;
        
        if(grid == null) return max;
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == 1){
                    int val = getIslands(i, j, grid, rows, cols);
                    if(val>max) max = val;
                }
            }
        }
        return max;
    }
    //dfs soln
    private int getIslands(int i, int j, int [][] grid, int rows, int cols){
        
        if(i<0 || j<0 || i>=rows || j>=cols || grid[i][j] != 1) return 0;
        
        grid[i][j] = 2;
        
        return 
            1+getIslands(i-1, j, grid, rows, cols) +
            getIslands(i, j-1, grid, rows, cols) +
            getIslands(i, j+1, grid, rows, cols) +
            getIslands(i+1, j, grid, rows, cols);
        
    }
}