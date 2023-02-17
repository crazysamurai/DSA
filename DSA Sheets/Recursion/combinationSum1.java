import java.util.*;

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> ls = new ArrayList<>();
        solve(candidates, target, ls, 0);
        return ans;
    }

    public void solve(int[] nums, int target, List<Integer> ls, int idx) {
        if (idx >= nums.length) {
            if (target == 0)
                ans.add(new ArrayList<>(ls));
            return;
        }
        if (target >= nums[idx]) {
            ls.add(nums[idx]);
            solve(nums, target - nums[idx], ls, idx);
            ls.remove(ls.size() - 1);
        }
        solve(nums, target, ls, idx + 1);
    }
}

// https://leetcode.com/problems/combination-sum/description/
