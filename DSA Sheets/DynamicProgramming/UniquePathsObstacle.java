//https://www.youtube.com/watch?v=TmhpgXScLyY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=11
//LC:https://leetcode.com/problems/unique-paths-ii/submissions/
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int n = obstacleGrid.length;
        int m = obstacleGrid[0].length;

        // int dp [][] = new int [n][m];
        // for(int [] val: dp){
        // Arrays.fill(val, -1);
        // }

        // tabulation

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    dp[0][0] = 1;
                    continue;
                }
                int up = 0;
                int left = 0;
                if (i > 0)
                    up = dp[i - 1][j];
                if (j > 0)
                    left = dp[i][j - 1];
                dp[i][j] = up + left;
            }
        }
        return dp[n - 1][m - 1];

        // return solve(n-1,m-1,obstacleGrid, dp);

        // space optimization
        int[] prev = new int[m];
        for (int i = 0; i < n; i++) {
            int temp[] = new int[m];
            for (int j = 0; j < m; j++) {
                if (i >= 0 && j >= 0 && obstacleGrid[i][j] == 1) {
                    temp[j] = 0;
                    continue;
                }
                if (i == 0 && j == 0) {
                    temp[j] = 1;
                    continue;
                }

                int up = 0;
                int left = 0;
                if (i > 0)
                    up = prev[j];
                if (j > 0)
                    left = temp[j - 1];
                temp[j] = up + left;
            }
            prev = temp;
        }
        return prev[m - 1];
    }

    public int solve(int i, int j, int[][] grid, int[][] dp) {
        // recursion
        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;

        int up = solve(i - 1, j, grid);
        int left = solve(i, j - 1, grid);
        return (up + left);

        // memoization

        if (i >= 0 && j >= 0 && grid[i][j] == 1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = solve(i - 1, j, grid, dp);
        int left = solve(i, j - 1, grid, dp);
        return dp[i][j] = up + left;

    }

}