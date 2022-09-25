//LC: https://leetcode.com/problems/number-of-closed-islands/
class Solution {
    public int closedIsland(int[][] grid) {

        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();

        // top row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 0 && vis[0][i] == 0)
                dfs(grid, vis, drow, dcol, n, m, 0, i);
        }

        // left col
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 0 && vis[i][0] == 0)
                dfs(grid, vis, drow, dcol, n, m, i, 0);
        }

        // bottom row
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 0 && vis[n - 1][i] == 0)
                dfs(grid, vis, drow, dcol, n, m, n - 1, i);
        }

        // right col
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 0 && vis[i][m - 1] == 0)
                dfs(grid, vis, drow, dcol, n, m, i, m - 1);
        }
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 0 && vis[i][j] == 0) {
                    count++;
                    dfs(grid, vis, drow, dcol, n, m, i, j);
                }
            }
        }

        return count;
    }

    public void dfs(int[][] grid, int[][] vis, int[] drow, int[] dcol, int n, int m, int r, int c) {
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 0 && vis[nrow][ncol] == 0) {
                dfs(grid, vis, drow, dcol, n, m, nrow, ncol);
            }
        }
    }

}