class Solution {
    public int[] twoSum(int[] numbers, int target) {
        Map <Integer, Integer> hm = new HashMap<>();
        int [] ans = new int [2];
        for(int i = 0; i<numbers.length; i++){
            int t = target-numbers[i];
            if(hm.containsKey(t)){
                ans[0] = hm.get(t)+1;//the array is 1-indexed
                ans[1] = i+1;
                return ans;
            }else{
                hm.put(numbers[i], i);
            }
        }
        return null;
    }
}
