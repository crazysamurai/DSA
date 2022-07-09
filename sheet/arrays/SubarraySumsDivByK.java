class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        int cs = 0;
        int freq[] = new int[k];
        int ans = 0;
        freq[0] = 1;
        for(int i = 0; i<nums.length; i++){
            cs += nums[i];
            int rem = cs%k;
            if(rem<0) rem+=k;
            ans+=freq[rem];
            freq[rem]++;
        }
        return ans;
    }
}
//https://leetcode.com/problems/subarray-sums-divisible-by-k/discuss/413234/DETAILED-WHITEBOARD!-BEATS-100-(Do-you-really-want-to-understand-It)