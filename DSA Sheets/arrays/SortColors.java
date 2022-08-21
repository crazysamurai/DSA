//dutch national flag algorithm
class Solution {
    public void sortColors(int[] nums) {
        int left = 0;
        int right = nums.length-1;
        int mid = 0;
        
        while(mid<=right){
            if(nums[mid] == 1) mid++;
            else if(nums[mid] == 0) {
                swap(mid,left, nums);
                left++;
                mid++;
            }else if(nums[mid] == 2) {
                swap(mid, right, nums);
                right--;
            }
        }
        
    }
    
    private void swap(int mid, int idx, int [] nums){
        int temp = 0;
        temp = nums[mid];
        nums[mid] = nums[idx];
        nums[idx] = temp;
    }
}
//https://www.youtube.com/watch?v=oaVa-9wmpns