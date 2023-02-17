class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> ls = new ArrayList<>();
        solve(candidates, target, ls, 0);
        return ans;
    }

    public void solve(int[] nums, int target, List<Integer> ls, int idx) {

        if (target == 0) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (i > idx && nums[i] == nums[i - 1])
                continue;
            if (target >= nums[i]) {
                ls.add(nums[i]);
                solve(nums, target - nums[i], ls, i + 1);
                ls.remove(ls.size() - 1);
            } else
                break;
        }
    }
}
// https://leetcode.com/problems/combination-sum-ii/description/
// https://www.youtube.com/watch?v=G1fRTGRxXU8&list=PLgUwDviBIf0p4ozDR_kJJkONnb1wdx2Ma&index=51