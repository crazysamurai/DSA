/*
 * knapsack problem
 * knapsack - bag
 * 0-1 : 0: pick, 1: not pick
 * input:
 * items 1, 2, 3, 4
 * weight 1, 3, 4, 5
 * Value 1, 4, 5, 7
 * 
 * Constraint : fix capacity of bag: 7kg
 * What we need to do: fill the bag with items such that the profit is max
 */

//gfg:https://practice.geeksforgeeks.org/problems/0-1-knapsack-problem0945/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab

class Solution {
    // Function to return max value that can be put in knapsack of capacity W.
    static int knapSack(int w, int wt[], int val[], int n) {
        // your code here

        // recursion
        if (w == 0 || n == 0)
            return 0;

        if (wt[n - 1] <= w) {
            return Math.max((val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1)), knapSack(w, wt, val, n - 1));
        }
        return knapSack(w, wt, val, n - 1);

        int[][] dp = new int[n + 1][w + 1];
        for (int arr[] : dp) {
            Arrays.fill(arr, -1);
        }
        solve(w, wt, val, n, dp);
        return dp[n][w];
    }

    // tabulation

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
                    dp[i][j] = Math.max((val[i - 1] + dp[i - 1][j - wt[i - 1]]), dp[i - 1][j]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
    }

    // memoization
    public static int solve(int w, int wt[], int val[], int n, int[][] dp) {
        if (n == 0 || w == 0)
            return 0;

        if (dp[n][w] != -1)
            return dp[n][w];

        if (wt[n - 1] <= w) {
            return dp[n][w] = Math.max((val[n - 1] + knapSack(w - wt[n - 1], wt, val, n - 1)),
                    knapSack(w, wt, val, n - 1));
        }
        return dp[n][w] = knapSack(w, wt, val, n - 1);
    }
}
