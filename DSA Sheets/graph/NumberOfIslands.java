class Solution {
    public int numIslands(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;
        int vis[][] = new int[rows][cols]; // this uses extra space, to get o(1) space just change the value of visited
                                           // cell in the grid to 2, that way we'll know it is visited.
        int count = 0;

        if (grid == null)
            return count;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1' && vis[i][j] == 0) {
                    getIslands(i, j, vis, grid, rows, cols);
                    count++;
                }
            }
        }
        return count;
    }

    // dfs soln
    private void getIslands(int i, int j, int[][] vis, char[][] grid, int rows, int cols) {

        if (i < 0 || j < 0 || i >= rows || j >= cols || vis[i][j] == 1 || grid[i][j] == '0')
            return;

        vis[i][j] = 1;

        getIslands(i - 1, j, vis, grid, rows, cols);// north
        getIslands(i, j - 1, vis, grid, rows, cols);// west
        getIslands(i, j + 1, vis, grid, rows, cols);// east
        getIslands(i + 1, j, vis, grid, rows, cols);// south

    }
}

// https://www.youtube.com/watch?v=ErPZFxugYkI

// BFS solution
// creating a pair class for storing indices in queue
class Pair {
    int first;
    int second;

    public Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    // Function to find the number of islands.
    public int numIslands(char[][] grid) {
        // Code here
        int n = grid.length;
        int m = grid[0].length;
        int[][] vis = new int[n][m];
        int count = 0;// to count the number of islands

        // traverse the grid and check for valid points to look for islands and call bfs
        // on them
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == '1' && vis[i][j] != 1) {
                    count++;
                    bfs(grid, i, j, vis, n, m);
                }
            }
        }
        return count;
    }

    public static void bfs(char[][] grid, int i, int j, int[][] vis, int n, int m) {

        vis[i][j] = 1;// set the first point as visited
        Queue<Pair> q = new LinkedList<Pair>();// queue to store the indices
        q.add(new Pair(i, j));

        while (!q.isEmpty()) {
            int row = q.peek().first; // don't use poll because it'll remove the val from the queue and we won't be
                                      // able to get column value
            int col = q.peek().second;
            q.remove();

            // we have to traverse in all 8 directions and if we make that in a diagram
            // we'll see that the value of indices for both rows and cols vary b/w -1 and 1
            // so we'll just loop generating all possible combinations of rows and cols
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    // generating new indices
                    int newRow = row + r;
                    int newCol = col + c;

                    // checking if the cols and rows generated are valid
                    if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && vis[newRow][newCol] != 1
                            && grid[newRow][newCol] == '1') {
                        vis[newRow][newCol] = 1; // setting the new cell as valid
                        q.add(new Pair(newRow, newCol)); // adding it to the queue so it can be traversed in the next
                                                         // iteration of while loop
                    }
                }
            }

        }

    }

}