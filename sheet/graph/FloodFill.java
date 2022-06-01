class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int rows = image.length;
        int cols = image[0].length;
        int oldColor = image[sr][sc];
        
        if(oldColor == newColor) return image;

        applyColor(image, sr, sc, newColor, oldColor, rows, cols);//no need to traverse the whole grid because you only need to color the blocks that are connected to the starting block and also have oldColor which can be handled by recursion
        return image;
    }
    
    private void applyColor(int [][]image, int i, int j, int newColor, int oldColor, int rows, int cols){
        if(i<0 || j<0 || i>=rows || j>=cols || image[i][j] != oldColor) return;
        image[i][j] = newColor;
        applyColor(image, i-1, j, newColor, oldColor, rows, cols);
        applyColor(image, i, j-1, newColor, oldColor, rows, cols);
        applyColor(image, i, j+1, newColor, oldColor, rows, cols);
        applyColor(image, i+1, j, newColor, oldColor, rows, cols);
    }
    
}