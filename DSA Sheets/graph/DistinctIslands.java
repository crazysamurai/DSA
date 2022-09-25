//GFG: https://practice.geeksforgeeks.org/problems/number-of-distinct-islands/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=number-of-distinct-islands
//https://www.youtube.com/watch?v=7zmgQSJghpo

class Solution {

    int countDistinctIslands(int[][] grid) {
        // Your Code here
        int n = grid.length;
        int m = grid[0].length;
        int vis[][] = new int[n][m];
        HashSet<ArrayList<String>> set = new HashSet<>(); // to count the number of distinct islands
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (vis[i][j] != 1 && grid[i][j] == 1) {
                    ArrayList<String> ls = new ArrayList<>();// store the current co-ordinate group
                    dfs(grid, vis, drow, dcol, ls, i, j, i, j, n, m);
                    set.add(ls);
                }
            }
        }
        return set.size();
    }

    public static void dfs(int[][] grid, int[][] vis, int[] dcol, int[] drow, ArrayList<String> ls, int r, int c,
            int br, int bc, int n, int m) {
        vis[r][c] = 1;
        ls.add(convert((r - br), (c - bc)));// add the diff in the list
        for (int i = 0; i < 4; i++) {
            int nrow = r + drow[i];
            int ncol = c + dcol[i];
            if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && grid[nrow][ncol] == 1 && vis[nrow][ncol] == 0) {
                dfs(grid, vis, drow, dcol, ls, nrow, ncol, br, bc, n, m);
            }
        }
    }

    private static String convert(int r, int c) {
        return Integer.toString(r) + " " + Integer.toString(c);// convert the diff into a string to store in the list
    }

}