class Solution {
    public int maxIceCream(int[] costs, int coins) {
        Arrays.sort(costs);
        int count = 0;
        for (int val : costs) {
            if (val <= coins) {
                coins -= val;
                count++;
            }
        }
        return count;
    }
}