//lc: https://leetcode.com/problems/maximum-bags-with-full-capacity-of-rocks/description/
class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = rocks.length;
        int diff[] = new int[n];

        for (int i = 0; i < n; i++)
            diff[i] = capacity[i] - rocks[i];
        Arrays.sort(diff);

        int idx = 0;
        while (additionalRocks > 0 && idx < n) {
            if (diff[idx] > additionalRocks)
                break;
            additionalRocks -= diff[idx];
            idx++;
        }

        return idx;
    }
}