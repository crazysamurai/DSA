//yt:https://www.youtube.com/watch?v=JJ5FxoLckMw
//lc:https://leetcode.com/problems/number-of-closed-islands/description/?envType=study-plan&id=graph-i
class Solution {
    public int closedIsland(int[][] grid) {
        int n = grid.length; // rows
        int m = grid[0].length; // columns

        int drow[] = { -1, 0, 1, 0 }; // row directions
        int dcol[] = { 0, 1, 0, -1 }; // column directions

        // traverse the boundary cells
        // top row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0)
                dfs(0, i, grid, n, m, drow, dcol);
        }

        // bottom row
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 0)
                dfs(n - 1, i, grid, n, m, drow, dcol);
        }

        // left column
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0)
                dfs(i, 0, grid, n, m, drow, dcol);
        }

        // right column
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 0)
                dfs(i, m - 1, grid, n, m, drow, dcol);
        }

        // counter for number of closed islands
        int count = 0;

        // now we are left with closed islands only and we perform dfs on each of them
        // to find how many of them are there
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0) {
                    dfs(i, j, grid, n, m, drow, dcol);
                    count++; // when a dfs call ends it means we have traversed a complete island so we
                             // increment the counter
                }
            }
        }
        return count;
    }

    public void dfs(int r, int c, int[][] grid, int n, int m, int[] drow, int[] dcol) {
        grid[r][c] = 2; // set cell visited
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i]; // new row
            int ncol = c + dcol[i]; // new column

            // check if new row and new column are valid
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0) {
                // if valid, call dfs on them as they are a part of current island
                dfs(nrow, ncol, grid, n, m, drow, dcol);
            }
        }

    }
}