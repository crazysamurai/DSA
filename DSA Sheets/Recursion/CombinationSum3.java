class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        int nums [] = {1,2,3,4,5,6,7,8,9};
        List<Integer> ls = new ArrayList<>();
        solve(nums, n, ls, 0, k);
        return ans;
    }

    public void solve(int[] nums, int target, List<Integer> ls, int idx, int k) {

        if (target == 0 && ls.size() == k) {
            ans.add(new ArrayList<>(ls));
            return;
        }

        for (int i = idx; i < nums.length; i++) {
            if (target >= nums[i]) {
                ls.add(nums[i]);
                solve(nums, target - nums[i], ls, i + 1, k);
                ls.remove(ls.size() - 1);
            } else
                break;
        }
    }

}

//https://leetcode.com/problems/combination-sum-iii/description/