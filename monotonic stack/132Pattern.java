class Solution {
    // stack
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        st.push(nums[n - 1]);

        int valueK = Integer.MIN_VALUE;

        for (int x = n - 2; x >= 0; x--) {
            if (st.peek() < nums[x]) {
                while (!st.isEmpty() && st.peek() < nums[x]) {
                    valueK = Math.max(st.peek(), valueK);
                    st.pop();
                }
            } else if (st.peek() > nums[x] && nums[x] < valueK) {
                return true;
            }
            st.push(nums[x]);
        }
        return false;
    }
}

// cleaner soln:

class Solution {
    /*
     * Mono Stack
     * TC: O(n)
     * SC: O(n)
     */
    public boolean find132pattern(int[] nums) {
        int n = nums.length;
        Stack<Integer> st = new Stack<>();
        int secondMax = Integer.MIN_VALUE;

        for (int x = n - 1; x >= 0; x--) {
            if (nums[x] < secondMax)
                return true;

            while (!st.isEmpty() && st.peek() < nums[x])
                secondMax = Math.max(st.pop(), secondMax);

            st.push(nums[x]);
        }
        return false;
    }
}