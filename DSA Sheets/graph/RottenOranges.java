//Only BFS is possible
// https://www.youtube.com/watch?v=yf3oUhkvqA0
class Pair {
    int first;
    int second;
    int time;

    public Pair(int first, int second, int time) {
        this.first = first;
        this.second = second;
        this.time = time;
    }
}

class Solution {
    // Function to find minimum time required to rot all oranges.
    public int orangesRotting(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        // traverse in 4 directions
        int[] rd = { -1, 0, 1, 0 };
        int[] cd = { 0, 1, 0, -1 };
        return bfs(grid, vis, n, m, rd, cd);
    }

    public int bfs(int[][] grid, int[][] vis, int n, int m, int[] rd, int[] cd) {
        Queue<Pair> q = new LinkedList<Pair>();
        int fresh = 0;// count the number of fresh oranges
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 2) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 2;
                }
                if (grid[i][j] == 1) {
                    fresh++;// increment if fresh
                }
            }
        }
        int ans = 0;
        int freshChk = 0;// verify the num of fresh oranges
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int t = q.peek().time;
            q.remove();
            ans = t;// store the time val

            for (int i = 0; i < 4; i++) {
                int newRow = row + rd[i];
                int newCol = col + cd[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] != 2
                        && grid[newRow][newCol] == 1) {
                    q.add(new Pair(newRow, newCol, t + 1));
                    vis[newRow][newCol] = 2;
                    freshChk++;// increment the val of number of fresh oranges encountered
                }
            }
        }
        if (fresh != freshChk)
            return -1;// return -1 if not all fresh oranges were rotten
        return ans;
    }

}