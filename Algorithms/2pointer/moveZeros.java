class Solution {
    public void moveZeroes(int[] nums) {
        if(nums.length==0 || nums == null)return;
        int i = 0;
        for(int j = 0; j<nums.length; j++){
            if(nums[j]!=0){
                nums[i] = nums[j];
                i++;
            }
        }
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}
// the key is to shift all the non zeros to the far left and fill the remains with 0