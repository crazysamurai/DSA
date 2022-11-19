class Solution {
    public int majorityElement(int[] nums) {
        // sorting soln, read editorial for explanation
        // Arrays.sort(nums);
        // return nums[nums.length/2];

        // Boyer-Moore Voting Algorithm (increase the count when same element occurs and
        // decrease otherwise)
        int count = 0;
        Integer ans = null;

        for (int val : nums) {
            if (count == 0)
                ans = val;
            if (val == ans)
                count++;
            else
                count--;
        }
        return ans;
    }
}