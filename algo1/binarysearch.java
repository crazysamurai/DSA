class Solution {
    public int search(int[] nums, int target) {
        Arrays.sort(nums);
        
        int i = 0;
        int j = nums.length-1;
        return bs(nums, i, j, target);
        
    }
    
    //recursive solution
    public int bs(int [] nums, int i, int j, int target){
        if(i>j)return -1;
        
        int mid = (i+j)/2;
        if(nums[mid] == target){
            return mid;
        }else if(nums[mid]<target){
            i=mid+1;
            return bs(nums, i, j, target);
        }else if(nums[mid]>target){
            j=mid-1;
            return bs(nums, i, j, target);
        }
        return -1;
    }

    //iterative
    public int bs(int [] nums, int i, int j, int target){
        while(i<=j){        
            int mid = (i+j)/2;
            
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid]<target){
                i=mid+1;
            }else if(nums[mid]>target){
                j=mid-1;
            }
        }
        return -1;
    }
}