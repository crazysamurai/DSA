//brute force would be using hashset
//optimal soln uses 2-ptr approach like following one
class Solution {
    public int removeDuplicates(int[] nums) {
        int i = 0;
        int j = 1;
        
        if(nums.length<1) return 0;
        
        while(j<nums.length){
            if(nums[i] != nums[j]){
                i++;
                nums[i] = nums[j];
            }
            j++;
        }
        return i+1;
    }
}
// https://www.youtube.com/watch?v=Fm_p9lJ4Z_8