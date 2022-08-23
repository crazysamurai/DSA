// similar to fibonacci
class Solution {
    public int climbStairs(int n) {
        // recursion
        if (n <= 1)
            return 1;
        int step1 = climbStairs(n - 1);
        int step2 = climbStairs(n - 2);
        return step1 + step2;

        // Tabulation
        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];

        // space optimization
        int prev = 1;
        int prev2 = 1;
        for (int i = 2; i <= n; i++) {
            int curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return prev;
        // return solve(n, dp);
    }

    // memoization
    public int solve(int n, int[] dp) {
        if (n <= 1)
            return 1;
        if (dp[n] != -1)
            return dp[n];
        return dp[n] = solve(n - 1, dp) + solve(n - 2, dp);
    }

}