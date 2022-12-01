import java.util.*;

class Solution {
    public int minimumEffortPath(int[][] heights) {
        int n = heights.length;
        int m = heights[0].length;
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        PriorityQueue<Pair> pq = new PriorityQueue<Pair>((x, y) -> x.effort - y.effort);
        int[][] effortArr = new int[n][m];
        for (int[] arr : effortArr) {
            Arrays.fill(arr, (int) 1e9);
        }
        effortArr[0][0] = 0;
        pq.add(new Pair(0, 0, 0));
        while (!pq.isEmpty()) {
            int eff = pq.peek().effort;
            int row = pq.peek().row;
            int col = pq.peek().col;
            pq.remove();

            if (row == n - 1 && col == m - 1)
                return eff;

            for (int i = 0; i < 4; i++) {
                int nrow = row + drow[i];
                int ncol = col + dcol[i];
                if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m) {
                    int newEff = Math.max(Math.abs(heights[row][col] - heights[nrow][ncol]), eff);
                    if (newEff < effortArr[nrow][ncol]) {
                        effortArr[nrow][ncol] = newEff;
                        pq.add(new Pair(newEff, nrow, ncol));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair {
    int effort, row, col;

    public Pair(int _effort, int _row, int _col) {
        this.effort = _effort;
        this.row = _row;
        this.col = _col;
    }
}