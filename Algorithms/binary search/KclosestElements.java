//https://www.youtube.com/watch?v=C_kHKUJuK0Y
// https://leetcode.com/problems/find-k-closest-elements/submissions/
class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        int n = arr.length;
        int l = 0;
        int r = n - 1;

        while (l <= r && r - l >= k) {
            if (Math.abs(arr[r] - x) > Math.abs(arr[l] - x)) {
                r--;
            } else if (Math.abs(arr[r] - x) < Math.abs(arr[l] - x)) {
                l++;
            } else if (Math.abs(arr[r] - x) == Math.abs(arr[l] - x)) {
                r--;
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (l <= r) {
            ans.add(arr[l]);
            l++;
        }
        return ans;
    }
}