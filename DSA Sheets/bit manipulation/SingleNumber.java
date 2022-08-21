class Solution {
    public int singleNumber(int[] nums) {
        int xor = 0;
        for(int i=0; i<nums.length; i++){
            xor^=nums[i];
        }
        return xor;
    }
}
// https://www.youtube.com/watch?v=5rtVTYAk9KQ&t=282s