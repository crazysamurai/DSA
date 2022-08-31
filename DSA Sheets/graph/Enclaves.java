class Solution {

    public int numEnclaves(int[][] grid) {

        // Your code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        Queue<Pair> q = new LinkedList<>();

        // top row
        for (int i = 0; i < m; i++) {
            if (grid[0][i] == 1 && vis[0][i] == 0)
                q.add(new Pair(0, i));
            vis[0][i] = 1;
        }

        // left col
        for (int i = 0; i < n; i++) {
            if (grid[i][0] == 1 && vis[i][0] == 0)
                q.add(new Pair(i, 0));
            vis[i][0] = 1;
        }

        // bottom row
        for (int i = 0; i < m; i++) {
            if (grid[n - 1][i] == 1 && vis[n - 1][i] == 0)
                q.add(new Pair(n - 1, i));
            vis[n - 1][i] = 1;
        }

        // right col
        for (int i = 0; i < n; i++) {
            if (grid[i][m - 1] == 1 && vis[i][m - 1] == 0)
                q.add(new Pair(i, m - 1));
            vis[i][m - 1] = 1;
        }

        bfs(q, grid, vis, drow, dcol);
        int count = 0;
        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (grid[i][j] == 1 && vis[i][j] == 0) {
                    vis[i][j] = 1;
                    count++;
                }
            }
        }
        return count;
    }

    public static void bfs(Queue<Pair> q, int[][] grid, int[][] vis, int[] drow, int[] dcol) {
        int n = grid.length;
        int m = grid[0].length;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();

            for (int i = 0; i < 4; i++) {
                int nRow = row + drow[i];
                int nCol = col + dcol[i];
                if (nRow >= 0 && nRow < n && nCol >= 0 && nCol < m && grid[nRow][nCol] == 1 && vis[nRow][nCol] == 0) {
                    q.add(new Pair(nRow, nCol));
                    vis[nRow][nCol] = 1;
                }
            }
        }
    }

}

class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}