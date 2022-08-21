class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        int n = nums.length;
        List<Integer> ls = new ArrayList<>();
        int freqArr [] = new int [n+1];
        for(int val : nums){
            freqArr[val]++;
        }
        
        for(int i = 1; i<n+1; i++){
            if(freqArr[i] == 2)ls.add(i);
        }
        return ls;
    }
}