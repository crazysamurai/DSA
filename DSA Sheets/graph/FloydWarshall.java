class Solution {
    public void shortest_distance(int[][] matrix) {
        // Code here
        int n = matrix.length;

        // ignore
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == -1)
                    matrix[i][j] = (int) 1e9;
                if (i == j)
                    matrix[i][j] = 0;
            }
        }

        // main loop
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    matrix[i][j] = Math.min(matrix[i][j], matrix[i][k] + matrix[k][j]);
                }
            }
        }

        // to check for -ve cycle
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == (int) 1e9)
                    matrix[i][j] = -1;
            }
        }
    }
}
// tc: O(n^3);