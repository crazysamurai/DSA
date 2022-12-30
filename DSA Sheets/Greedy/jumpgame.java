//lc: https://leetcode.com/problems/jump-game/description/
//soln:https://leetcode.com/problems/jump-game/solutions/2951775/java-c-greedy/

class Solution {
    public boolean canJump(int[] nums) {
        int target = nums.length - 1;
        int current = target - 1;
        int start = 0;

        while (start <= current) {
            if (nums[current] + current >= target) {
                target = current;
            }
            current--;
        }
        if (target == start)
            return true;
        return false;
    }
}