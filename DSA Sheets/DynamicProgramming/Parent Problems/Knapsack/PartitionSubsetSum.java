//LC:https://leetcode.com/problems/partition-equal-subset-sum/description/
class Solution {
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for (int val : nums)
            sum += val;
        if (sum % 2 != 0)
            return false;

        int target = sum / 2;

        boolean dp[][] = new boolean[n + 1][target + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= target; j++) {
                if (j == 0)
                    dp[i][j] = true;
                if (i == 0)
                    dp[i][j] = false;
            }
        }
        dp[0][0] = true;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] || dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][target];
    }
}