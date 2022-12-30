class Solution {
    public int minStoneSum(int[] piles, int k) {
        int ans = 0;
        // creating a max heap
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        // filling it with values of piles
        for (int val : piles)
            pq.offer(val);

        /*
         * the problem states that we need to perform the operation K times, so
         * following problems arises:
         * In order to get the min sum remaining, we must perform the operation on
         * larger values, and we
         * might need to perform the same operation on same value/pile again and again
         * as long as it is
         * the largest value/pile.
         * If we try to sort the array and then traverse it decreasing the values of
         * maximums then we might
         * have to sort and traverse the array multiple times which won't be very
         * efficient and will require
         * us touse multiple conditional statements.
         * So a better solution would be using a MaxHeap/PriorityQueue.
         * We fill it with all the values from piles[] and due to it's nature it'll sort
         * the values in desc order.
         * Now we just need to remove the first value (largest value), perform the
         * operation and add it back into the queue.
         * If the value we just operated on is still the largest, it'll come to the top
         * again and we can perform the same operation
         * on it again as long as k>0.
         */
        while (k > 0 && !pq.isEmpty()) {
            int val = pq.poll();
            val -= (int) (val / 2);
            pq.offer(val);
            k--;
        }

        while (!pq.isEmpty())
            ans += pq.poll();

        return ans;
    }
}