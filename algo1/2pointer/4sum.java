class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        
        if(nums==null || nums.length==0) return ans;
        Arrays.sort(nums);//important for searching the 2 required elts
        //multiple pointers 2 for the first 2 elts i&j, 2 for the remaining 2 elts left & right
        for(int i = 0; i<nums.length; i++){
            for(int j = i+1; j<nums.length; j++){
                int newTarget = target-nums[i]-nums[j];
                int left = j+1;
                int right = nums.length-1;
                while(left<right){
                    if(nums[left]+nums[right]<newTarget){
                        left++;                        
                    }else if(nums[left]+nums[right]>newTarget){
                        right--;
                    }else{
                        List<Integer> ls = new ArrayList<>(); //if we reach here that means the required pair was found
                        ls.add(nums[i]);
                        ls.add(nums[j]);
                        ls.add(nums[left]);
                        ls.add(nums[right]);
                        ans.add(ls);
                        
                        while(left<right && nums[left]==ls.get(2)) left++;//this is to skip the duplicate values in the array
                        while(left<right && nums[right]==ls.get(3)) right--;
                    } 
                }
                
                
                while(j<nums.length-1 && nums[j]==nums[j+1]) j++; //skip the duplicate value of nums[j]
            }
            while(i<nums.length-1 && nums[i]==nums[i+1]) i++;//skip the duplicates
        }
        return ans;
    }
}

// https://www.youtube.com/watch?v=4ggF3tXIAp0&list=PLgUwDviBIf0rVwua0kKYlsS_ik_1lyVK_&index=2&ab_channel=takeUforward