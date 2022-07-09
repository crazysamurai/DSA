class Solution {
    public void moveZeroes(int[] nums) {
        //two pointer approach
        int i = 0; //ptr 1

        //traverse through the array and move the non-zero elts to the front
        for(int j = 0; j<nums.length; j++){
            if(nums[j] != 0){
                nums[i] = nums[j];
                i++;
            }
        }
        //set rest of the places in the array to zero        
        while(i<nums.length){
            nums[i] = 0;
            i++;
        }
    }
}