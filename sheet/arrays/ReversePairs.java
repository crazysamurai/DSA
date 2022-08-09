class Solution {
    public int reversePairs(int[] nums) {
        return sort(0, nums.length-1, nums);
    }
    
    public int sort(int low, int high, int [] nums){//merge sort
        if(low>=high) return 0;
        int mid = (low+high)/2;
        
        int reverse = sort(low, mid, nums);//calling left recursion
        reverse+=sort(mid+1, high, nums);//calling right recursion
        
        reverse+=compare(nums, low, high, mid);//merge and compare
        return reverse;
    }
    
    public int compare(int[] nums, int low, int high, int mid){
        //comparison
        int count = 0;
        int j = mid+1;
        
        for(int i = low; i<mid+1; i++){
            while(j<=high && nums[i] > (2 * (long)nums[j])){//long to pass this test case:      [2147483647,2147483647,2147483647,2147483647,2147483647,2147483647]

                j++;
            }
            count+=(j-(mid+1));
        }
        
        //merge and sort the array
        ArrayList<Integer> ans = new ArrayList<>();
        int left = low;
        int right = mid+1;
        
        while(left<=mid && right<=high){
            if(nums[left]<nums[right]){
                ans.add(nums[left]);
                left++;
            }else{
                ans.add(nums[right]);
                right++;
            }
        }
        
        //adding the remaining elements from either half to the final list
        while(left<=mid){
            ans.add(nums[left]);
            left++;
        }
        
        while(right<=high){
            ans.add(nums[right]);
            right++;
        }
        
        //storing the sorted elements in the original array
        for(int i = low; i<=high; i++){
            nums[i] = ans.get(i-low);
        }
        return count;
        
    }
    
}
//https://www.youtube.com/watch?v=S6rsAlj_iB4&t=446s