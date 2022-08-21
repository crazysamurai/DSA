class Solution {
    public int[] sortedSquares(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int [] copy = new int [nums.length];
        int copyIdx = copy.length-1;
        
        while(left<=right){
            if(Math.abs(nums[left])>=Math.abs(nums[right])){
                copy[copyIdx] = nums[left]*nums[left];
                left++;
                copyIdx--;
            }else{
                copy[copyIdx] = nums[right]*nums[right];
                right--;
                copyIdx--;
            }
        }
        return copy;
    }
}