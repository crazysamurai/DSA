//old code

// class Solution {
//     public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
//         int rows = image.length;
//         int cols = image[0].length;
//         int oldColor = image[sr][sc];

//         if(oldColor == newColor) return image;

//         applyColor(image, sr, sc, newColor, oldColor, rows, cols);//no need to traverse the whole grid because you only need to color the blocks that are connected to the starting block and also have oldColor which can be handled by recursion
//         return image;
//     }

//     private void applyColor(int [][]image, int i, int j, int newColor, int oldColor, int rows, int cols){
//         if(i<0 || j<0 || i>=rows || j>=cols || image[i][j] != oldColor) return;
//         image[i][j] = newColor;
//         applyColor(image, i-1, j, newColor, oldColor, rows, cols);
//         applyColor(image, i, j-1, newColor, oldColor, rows, cols);
//         applyColor(image, i, j+1, newColor, oldColor, rows, cols);
//         applyColor(image, i+1, j, newColor, oldColor, rows, cols);
//     }

// }

//new code (dfs)
class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        // Code here
        int oldColor = image[sr][sc];
        // directions in which we need to check
        int[] nrow = { -1, 0, 1, 0 };
        int[] ncol = { 0, +1, 0, -1 };

        dfs(image, sr, sc, newColor, oldColor, nrow, ncol);
        return image;
    }

    public static void dfs(int[][] image, int sr, int sc, int newColor, int oldColor, int[] nrow, int[] ncol) {
        image[sr][sc] = newColor;// setting the new color

        // generating next col and row to move to
        for (int i = 0; i < 4; i++) {
            int nextRow = sr + nrow[i];
            int nextCol = sc + ncol[i];
            // checking if the current position is valid
            if (nextRow >= 0 && nextCol >= 0 && nextRow < image.length && nextCol < image[0].length
                    && image[nextRow][nextCol] == oldColor && image[nextRow][nextCol] != newColor) {
                dfs(image, nextRow, nextCol, newColor, oldColor, nrow, ncol);
            }

        }
    }

}