//lc: https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/description/
public class Solution {
    public int findMinArrowShots(int[][] points) {
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));

        int arrows = 1;
        int val = points[0][1];

        for (int i = 0; i < points.length; i++) {
            if (val < points[i][0]) {
                arrows++;
                val = points[i][1];
            }
        }
        return arrows;
    }
}