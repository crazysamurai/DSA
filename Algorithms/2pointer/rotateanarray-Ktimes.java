class Solution {
    public void rotate(int[] nums, int k) {
        if(k>nums.length){k = k%nums.length;} //for the following test cases
//[-1]
// 2
// [1,2]
// 3
        reverse(0, nums.length-k-1, nums);
        reverse(nums.length-k, nums.length-1, nums);
        reverse(0, nums.length-1, nums);
    }
    
    public void reverse(int i,int j, int[]nums){
        while(i<j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
            i++;
            j--;
        }
    }
}