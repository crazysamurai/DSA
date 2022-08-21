// https://www.youtube.com/watch?v=edXdVwkYHF8
//BFS solution because we need to find the minimum distance like in rotten oranges
class Solution {
    // Function to find distance of nearest 1 in the grid for each cell.
    public int[][] nearest(int[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        int dis[][] = new int[n][m];// distance matrix
        Queue<Pair> q = new LinkedList<Pair>();

        // loop through the grid and put 1 in vis where the 1 is encountered and add the
        // indices to the queue as this is a multi point bfs
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    vis[i][j] = 1;
                    q.add(new Pair(i, j, 0));
                }
            }
        }

        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int dist = q.peek().third;
            q.remove();
            dis[row][col] = dist;// add the distance to the dist matrix of nearest 1 to that 0

            for (int i = 0; i < 4; i++) {
                int newRow = row + drow[i];
                int newCol = col + dcol[i];
                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] == 0) {
                    q.add(new Pair(newRow, newCol, dist + 1));
                    vis[newRow][newCol] = 1;
                }
            }
        }
        return dis;
    }
}