class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int vis [][] = new int [rows][cols]; //this uses extra space, to get o(1) space just change the value of visited cell in the grid to 2, that way we'll know it is visited.
        int count = 0;
        
        if(grid == null) return count;
        
        for(int i = 0; i<rows; i++){
            for(int j = 0; j<cols; j++){
                if(grid[i][j] == '1' && vis[i][j] == 0){
                    getIslands(i, j, vis, grid, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }
    //dfs soln
    private void getIslands(int i, int j, int [][] vis, char [][] grid, int rows, int cols){
        
        if(i<0 || j<0 || i>=rows || j>=cols || vis[i][j] == 1 || grid[i][j] == '0') return;
        
        vis[i][j] = 1;
        
        getIslands(i-1, j, vis, grid, rows, cols);//north
        getIslands(i, j-1, vis, grid, rows, cols);//west
        getIslands(i, j+1, vis, grid, rows, cols);//east
        getIslands(i+1, j, vis, grid, rows, cols);//south
        
    }
}

//https://www.youtube.com/watch?v=ErPZFxugYkI