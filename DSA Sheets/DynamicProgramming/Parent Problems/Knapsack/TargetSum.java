// lc: https://leetcode.com/problems/target-sum/description/
class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        int d = target;
        int sum = 0;
        for (int x : nums)
            sum += x;

        if (sum - d < 0 || (sum - d) % 2 == 1)
            return 0; // because all the numbers are greater than zero so the sum can't be -ve and it
                      // is to be divided by 2 so it can't be odd

        int s1 = (sum - d) / 2;
        int[][] dp = new int[n + 1][s1 + 1];
        dp[0][0] = 1;

        for (int i = 1; i < n + 1; i++) {
            for (int j = 0; j < s1 + 1; j++) {// we start from 0 because we need to handle the case with multiple 0s
                                              // which would increase the number of subsets possible
                if (nums[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j - nums[i - 1]] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][s1];
    }
}