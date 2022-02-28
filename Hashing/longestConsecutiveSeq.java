class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        int longestSeq = 0;
        for(int i = 0; i<nums.length; i++){
            hs.add(nums[i]);
        }
            
        for(int i = 0; i<nums.length; i++){
            if(!hs.contains(nums[i]-1)){
                int curr = nums[i];
                int count = 1;
                while(hs.contains(curr+1)){
                    curr = curr+1;
                    count++;
                }
                longestSeq = Math.max(count, longestSeq);
            }
        }
        return longestSeq;
    }
}