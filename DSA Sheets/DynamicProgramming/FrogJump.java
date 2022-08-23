import java.util.Arrays;

public class Solution {
    public static void solve(int n, int heights[], int[] dp) {

        // recursive solution
        if (n == 0)
            return 0;
        int step1 = solve(n - 1, heights) + Math.abs(heights[n] - heights[n - 1]);
        int step2 = Integer.MAX_VALUE;
        if (n > 1)
            step2 = solve(n - 2, heights) + Math.abs(heights[n] - heights[n - 2]);
        return Math.min(step1, step2);

        // memoization
        if (n == 0)
            return 0;
        if (dp[n] != -1)
            return dp[n];
        int step1 = solve(n - 1, heights, dp) + Math.abs(heights[n] - heights[n - 1]);
        int step2 = Integer.MAX_VALUE;
        if (n > 1)
            step2 = solve(n - 2, heights, dp) + Math.abs(heights[n] - heights[n - 2]);
        return dp[n] = Math.min(step1, step2);

    }

    public static int frogJump(int n, int heights[]) {
        return solve(n - 1, heights);

        // memoization
        int dp[] = new int[n];
        Arrays.fill(dp, -1);

        // tabulation
        dp[0] = 0;
        for (int i = 1; i < n; i++) {
            int step1 = dp[i - 1] + Math.abs(heights[i] - heights[i - 1]);
            int step2 = Integer.MAX_VALUE;
            if (i > 1)
                step2 = dp[i - 2] + Math.abs(heights[i] - heights[i - 2]);
            dp[i] = Math.min(step1, step2);
        }
        return dp[n - 1];

        // space optimization
        int prev = 0;
        int prev2 = 0;
        for (int i = 1; i < n; i++) {
            int step1 = prev + Math.abs(heights[i] - heights[i - 1]);
            int step2 = Integer.MAX_VALUE;
            if (i > 1) {
                step2 = prev2 + Math.abs(heights[i] - heights[i - 2]);
            }
            int curr = Math.min(step1, step2);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}