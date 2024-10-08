//gfg: https://practice.geeksforgeeks.org/problems/subset-sum-problem-1611555638/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=subset-sum-problem-1611555638

class Solution {
    static Boolean isSubsetSum(int n, int arr[], int sum) {
        // code here
        boolean[][] dp = new boolean[n + 1][sum + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (j == 0)
                    dp[i][j] = true;
                if (i == 0)
                    dp[i][j] = false;
            }
        }
        dp[0][0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= sum; j++) {
                if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - arr[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}