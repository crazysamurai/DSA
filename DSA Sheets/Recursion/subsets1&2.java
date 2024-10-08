class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        fun(nums, 0, list, ans);
        return ans;
    }

    public void fun(int[] nums, int idx, List<Integer> list, List<List<Integer>> ans) {
        ans.add(new ArrayList<>(list));
        for (int i = idx; i < nums.length; i++) {
            if (idx != i && nums[i] == nums[i - 1])
                continue;// this condition is used to avoid duplicate cases
            list.add(nums[i]);
            fun(nums, i + 1, list, ans);
            list.remove(list.size() - 1);
        }
    }
}
// https://www.youtube.com/watch?v=RIn3gOkbhQE&list=PLgUwDviBIf0rGlzIn_7rsaR2FQ5e6ZOL9&index=11&ab_channel=takeUforward

class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> ls = new ArrayList<>();
        solve(nums, 0, ls);
        return ans;
    }

    public void solve(int[] nums, int idx, List<Integer> ls) {
        if (idx >= nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[idx]);
        solve(nums, idx + 1, ls);
        ls.remove(ls.size() - 1);
        solve(nums, idx + 1, ls);
    }
}
