class Solution {
    //modified prefix sum
    public int subarraySum(int[] nums, int k) {
        Map<Integer, Integer> hm = new HashMap<>();
        hm.put(0,1); //store the initial sum as 0 in the hashmap with freq 1
        int r = 0;
        int sum = 0;
        int count = 0;

        while(r<nums.length){
            sum+=nums[r];
            
            if(hm.containsKey(sum-k)){
                count+=hm.get(sum-k);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
            r++;
        }
        return count;
    }
}
//https://www.youtube.com/watch?v=20v8zSo2v18