import java.util.*;

//https://www.youtube.com/watch?v=GrMBfJNk_NY&list=PLgUwDviBIf0qUlt5H_kiKYaNSqJ81PMMY&index=6
//CodeStudio:https://www.codingninjas.com/codestudio/problems/maximum-sum-of-non-adjacent-elements_843261?source=youtube&campaign=striver_dp_videos&utm_source=youtube&utm_medium=affiliate&utm_campaign=striver_dp_videos&leftPanelTab=1

//THIS QUESTION IS SIMILAR TO HOUSE ROBBER ON LEETCODE: https://leetcode.com/problems/house-robber/submissions/

public class Solution {
    public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
        // Write your code here.
        int n = nums.size();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = nums.get(i);
        }
        return solve(n - 1, arr);

        // memoization
        int dp[] = new int[n + 1];
        Arrays.fill(dp, -1);
        return solve(n - 1, arr, dp);

        // tabulation

        dp[0] = arr[0];
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += dp[i - 2];
            int notPick = 0 + dp[i - 1];
            dp[i] = Math.max(pick, notPick);
        }
        return dp[n - 1];

        // space optimization
        int prev = arr[0]; // convert base case i.e idx = 0 return arr[0];
        int prev2 = 0;// idx<0 return 0
        for (int i = 1; i < n; i++) {
            int pick = arr[i];
            if (i > 1)
                pick += prev2;
            int notPick = 0 + prev;
            int curr = Math.max(pick, notPick);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }

    public static int solve(int idx, int[] nums, int[] dp) {
        // recursive
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;
        int pick = nums[idx] + solve(idx - 2, nums);
        int notPick = 0 + solve(idx - 1, nums);
        return Math.max(pick, notPick);

        // memoization
        if (idx == 0)
            return nums[0];
        if (idx < 0)
            return 0;

        if (dp[idx] != -1)
            return dp[idx];
        int pick = nums[idx] + solve(idx - 2, nums, dp);
        int notPick = 0 + solve(idx - 1, nums, dp);
        return dp[idx] = Math.max(pick, notPick);
    }

}