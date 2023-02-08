//count sort
class Solution {
    public void sortColors(int[] nums) {
        int o = 0, t = 0, z = 0;
        for(int i = 0; i<nums.length; i++){
            if(nums[i] == 1) o++;
            else if(nums[i] == 2) t++;
            else z++;
        }
        int i = 0;
        while(i<nums.length){
            if(z>0){
                nums[i] = 0;
                z--;
            }
            else if(o>0){
                 nums[i] = 1;
                 o--;
            }
            else{
                nums[i] = 2;
                t--;
            }

            i++;
        }
    }
}

//dutch national flag algorithm
// 0 stays before left
// 2 stays after right
// 1 stays in mid 
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