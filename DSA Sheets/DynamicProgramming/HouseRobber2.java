//Leetcode: https://leetcode.com/problems/house-robber-ii/submissions/
//https://www.youtube.com/watch?v=3WaxQMELSkw&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=7

class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if (n == 1)
            return nums[0];

        int temp1[] = new int[n];
        int temp2[] = new int[n];

        for (int i = 0; i < n; i++) {
            if (i != 0)
                temp1[i] = nums[i];
            if (i != n - 1)
                temp2[i] = nums[i];
        }

        int[] dp1 = new int[n + 1];
        Arrays.fill(dp1, -1);
        int[] dp2 = new int[n + 1];
        Arrays.fill(dp2, -1);

        int ans1 = solve(temp1, n - 1);
        int ans2 = solve(temp2, n - 1);

        return Math.max(ans1, ans2);

    }

    public int solve(int[] arr, int idx) {
        // recursive
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;

        int pick = arr[idx] + solve(arr, idx - 2);
        int notpick = 0 + solve(arr, idx - 1);

        return Math.max(pick, notpick);

        // memoization
        if (idx == 0)
            return arr[0];
        if (idx < 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];

        int pick = arr[idx] + solve(arr, idx - 2, dp);
        int notpick = 0 + solve(arr, idx - 1, dp);

        return dp[idx] = Math.max(pick, notpick);

        // tabulation
        dp[0] = arr[0];
        for (int i = 1; i <= idx; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int notpick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notpick);
        }
        return dp[idx];

        // space optimization
        int prev = arr[0];
        int prev2 = 0;
        for (int i = 1; i <= idx; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int notpick = 0 + prev;
            int curr = Math.max(pick, notpick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}