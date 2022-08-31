//https://www.youtube.com/watch?v=BtdgAys4yMk&list=PLgUwDviBIf0oE3gA41TKO2H5bHpPd7fzn&index=14
//GFG:https://practice.geeksforgeeks.org/problems/replace-os-with-xs0052/1?utm_source=youtube&utm_medium=collab_striver_ytdescription&utm_campaign=replace-os-with-xs
//LC:https://leetcode.com/problems/surrounded-regions/submissions/
class Solution {
    static char[][] fill(int n, int m, char a[][]) {
        // code here
        int vis[][] = new int[n][m];
        int drow[] = { -1, 0, 1, 0 };
        int dcol[] = { 0, 1, 0, -1 };

        // top row
        for (int i = 0; i < m; i++) {
            if (a[0][i] == 'O' && vis[0][i] == 0)
                dfs(0, i, vis, a, drow, dcol, n, m);
        }

        // left col
        for (int i = 0; i < n; i++) {
            if (a[i][0] == 'O' && vis[i][0] == 0)
                dfs(i, 0, vis, a, drow, dcol, n, m);
        }

        // bottom row
        for (int i = 0; i < m; i++) {
            if (a[n - 1][i] == 'O' && vis[n - 1][i] == 0)
                dfs(n - 1, i, vis, a, drow, dcol, n, m);
        }

        // right col
        for (int i = 0; i < n; i++) {
            if (a[i][m - 1] == 'O' && vis[i][m - 1] == 0)
                dfs(i, m - 1, vis, a, drow, dcol, n, m);
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = 1; j < m - 1; j++) {
                if (a[i][j] == 'O' && vis[i][j] == 0) {
                    a[i][j] = 'X';
                    vis[i][j] = 1;
                }
            }
        }

        return a;
    }

    public static void dfs(int r, int c, int[][] vis, char[][] a, int[] drow, int[] dcol, int n, int m) {
        vis[r][c] = 1;

        for (int i = 0; i < 4; i++) {
            int newRow = r + drow[i];
            int newCol = c + dcol[i];

            if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && a[newRow][newCol] == 'O'
                    && vis[newRow][newCol] == 0) {
                dfs(newRow, newCol, vis, a, drow, dcol, n, m);
            }
        }

    }

}