class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i<nums.length; i++){
            pq.add(nums[i]);
        }
        int i = 0;
        int x = 0;
        while(i<k){
            x = pq.remove();
            i++;
        }
        return x;
    }
}