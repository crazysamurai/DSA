class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int[][] pac = new int[n][m];
        int[][] atl = new int[n][m];
        List<List<Integer>> ans = new ArrayList<>();
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        // rows
        for (int i = 0; i < m; i++) {
            dfs(heights, pac, 0, i, drow, dcol, n, m);
            dfs(heights, atl, n - 1, i, drow, dcol, n, m);
        }

        // cols
        for (int i = 0; i < n; i++) {
            dfs(heights, pac, i, 0, drow, dcol, n, m);
            dfs(heights, atl, i, m - 1, drow, dcol, n, m);
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (pac[i][j] == 1 && atl[i][j] == 1) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;

    }

    public void dfs(int[][] grid, int[][] vis, int r, int c, int[] drow, int[] dcol, int n, int m) {
        vis[r][c] = 1;
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && vis[nrow][ncol] != 1
                    && grid[nrow][ncol] >= grid[r][c]) {
                dfs(grid, vis, nrow, ncol, drow, dcol, n, m);
            }
        }
    }

}