// https://www.youtube.com/watch?v=onLoX6Nhvmg
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        //just convert the problem into 2sum, A+B+C=0 => B+C=-A
        Arrays.sort(nums);
        List<List<Integer>> ls = new ArrayList<>();
        //loop to find 'A', the first of tripplets, we'll keep this constant while we find the other two
        for(int i = 0; i<nums.length-2; i++){ //inorder to form tripplets it needs to have atleast two elements after itself
            if(i==0 || (i>0 && nums[i] != nums[i-1])){//to remove the duplicate value of 'A'
                //starting 2ptr approach for finding the other two elts
                int l = i+1;
                int r = nums.length-1;
                int sum = 0-nums[i]; //B+C=-A
                
                while(l<r){
                    if(nums[l] + nums[r] == sum){//tripplet found
                        ls.add(Arrays.asList(nums[i], nums[l], nums[r]));
                        
                        while(l<r && nums[l] == nums[l+1])l++; //move the pointers to avoid duplicate triplets
                        while(l<r && nums[r] == nums[r-1])r--;
                        
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] < sum) l++;
                    else r--;
                }
                
            }
        }
        return ls;
    }
}