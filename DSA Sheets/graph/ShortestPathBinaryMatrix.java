import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {

        int n = grid.length;

        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1; // if the starting point or ending point has value 1, we don't proceed
        if (n - 1 == 0)
            return 1; // there is only 1 cell in the grid then path length = 1

        Queue<Pair> q = new LinkedList<>(); // queue to store the distance with corresponding cell co-ordinates

        int disArr[][] = new int[n][n]; // A distance grid that stores distance to all the cells from starting cell

        for (int[] arr : disArr) // fill the distance grid with a large distance feo each cell so that we can
                                 // compare and replace with smaller distance later
            Arrays.fill(arr, (int) 1e9);

        disArr[0][0] = 1; // set starting distance to 1

        q.add(new Pair(1, 0, 0)); // insert the starting cell and distance in the empty queue, Pair(distance, row,
                                  // column)

        while (!q.isEmpty()) {
            int dis = q.peek().dis;
            int row = q.peek().row;
            int col = q.peek().col;
            q.remove();

            // A simpler way to generate and traverse in all 8 directions of current cell
            for (int r = -1; r <= 1; r++) {
                for (int c = -1; c <= 1; c++) {
                    int nrow = row + r; // new row
                    int ncol = col + c; // new column

                    // checking if the new row and column are valid
                    if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < n && grid[nrow][ncol] == 0
                            && disArr[nrow][ncol] > dis + 1) {
                        if (nrow == n - 1 && ncol == n - 1)
                            return dis + 1;// if we've reached the destination i.e. end of the grid, the total
                                           // distance/length of path = distance+1, 1 for the current cell

                        disArr[nrow][ncol] = dis + 1;// if this is not the destination then update the distance to
                                                     // current cell in the distance array
                        q.add(new Pair(dis + 1, nrow, ncol));
                    }
                }
            }

        }
        return -1;// if it's not possible to reach the destination return -1
    }
}

class Pair {
    int dis, row, col;

    public Pair(int _dis, int _row, int _col) {
        this.dis = _dis;
        this.row = _row;
        this.col = _col;
    }
}