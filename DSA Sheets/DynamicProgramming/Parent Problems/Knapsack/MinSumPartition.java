//gfg:https://practice.geeksforgeeks.org/problems/minimum-sum-partition3317/1?utm_source=geeksforgeeks&utm_medium=article_practice_tab&utm_campaign=article_practice_tab
class Solution {

    public int minDifference(int nums[], int n) {
        // Your code goes here
        int range = 0;

        for (int val : nums)
            range += Math.abs(val);

        // int n = nums.length;
        boolean dp[][] = new boolean[n + 1][range + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= range / 2; j++) {
                if (i == 0)
                    dp[i][j] = false;
                if (j == 0)
                    dp[i][j] = true;
            }
        }

        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= range / 2; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        int mini = (int) (1e9);
        for (int i = 0; i <= range; i++) {
            if (dp[n][i] == true) {
                int diff = Math.abs(i - (range - i));
                mini = Math.min(mini, diff);
            }
        }
        return mini;
    }
}
