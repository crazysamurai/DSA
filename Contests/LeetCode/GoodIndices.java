// https://www.youtube.com/watch?v=ffJ2QTDWz-A
class Solution {
    public List<Integer> goodIndices(int[] nums, int k) {
        List<Integer> ans = new ArrayList<>();
        int n = nums.length;
        int arrLR[] = new int[n];
        int arrRL[] = new int[n];
        arrLR[0] = 1;
        arrRL[n - 1] = 1;

        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[i - 1])
                arrLR[i] = 1 + arrLR[i - 1];
            else
                arrLR[i] = 1;
        }
        for (int i = n - 2; i >= 0; i--) {
            if (nums[i] <= nums[i + 1])
                arrRL[i] = 1 + arrRL[i + 1];
            else
                arrRL[i] = 1;
        }
        for (int i = k; i < n - k; i++) {
            if (arrLR[i - 1] >= k && arrRL[i + 1] >= k)
                ans.add(i);
        }

        return ans;
    }
}