// m is the given matrix and n is the order of matrix
class Solution {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        int vis[][] = new int[n][n];
        ArrayList<String> ls = new ArrayList<>();
        int di[] = { 1, 0, 0, -1 };
        int dj[] = { 0, -1, 1, 0 };

        if (m[0][0] == 1)
            path(0, 0, di, dj, "", vis, m, n, ls);
        return ls;
    }

    private static void path(int i, int j, int[] di, int dj[], String ans, int[][] vis, int[][] m, int n,
            ArrayList<String> ls) {
        if (i == n - 1 && j == n - 1) {
            ls.add(ans);
            return;
        }
        String dir = "DLRU";
        for (int x = 0; x < 4; x++) {
            int ni = i + di[x];
            int nj = j + dj[x];

            if (ni < n && nj < n && ni >= 0 && nj >= 0 && vis[ni][nj] != 1 && m[ni][nj] == 1) {
                vis[i][j] = 1;
                path(ni, nj, di, dj, ans + dir.charAt(x), vis, m, n, ls);
                vis[i][j] = 0;
            }
        }
    }
}