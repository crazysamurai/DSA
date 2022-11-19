class Solution {
    public int longestSubarray(int[] nums) {

        // the max bitwise AND value can only be achieved through the maximum element in
        // the array so we need to find the max elt and the longest subarray where it
        // occurs consecutively
        // ex: {1,3,6,6,8,5,6,8,8} here the max elt is 8 and the longest subarray is
        // formed by last two elements, so that's the answer
        int maxVal = 0;
        for (int val : nums) {
            maxVal = Math.max(val, maxVal);
        }
        int length = 0;
        int maxLength = 1;
        for (int val : nums) {
            if (val == maxVal)
                length++;
            else
                length = 0;
            maxLength = Math.max(length, maxLength);
        }
        return maxLength;
    }
}
