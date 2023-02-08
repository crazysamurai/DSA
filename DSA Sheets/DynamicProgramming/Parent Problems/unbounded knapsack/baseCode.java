public static void solve(int w, int wt[], int val[], int n, int[][] dp) {
    for (int i = 0; i <= n; i++) {
        for (int j = 0; j <= w; j++) {
            if (i == 0 || j == 0)
                dp[i][j] = 0;
        }
    }
    for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= w; j++) {
            if (wt[i - 1] <= j) {
                dp[i][j] = Math.max((val[i - 1] + dp[i][j - wt[i - 1]]), dp[i - 1][j]); //only change is dp[i] instead if dp[i-1]
            } else {
                dp[i][j] = dp[i - 1][j];
            }
        }
    }
}