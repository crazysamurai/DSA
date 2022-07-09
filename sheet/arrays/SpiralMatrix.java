class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> ls = new ArrayList<>();
        
        int m = matrix[0].length;
        int n = matrix.length;
        int minrow = 0;
        int mincol = 0;
        int maxrow = matrix.length-1;
        int maxcol = matrix[0].length-1;
        int elts = m*n;
        int count = 0;
        
        while(count<elts){
            //top
            for(int i = minrow, j = mincol; j<=maxcol && count<elts; j++){
                ls.add(matrix[i][j]);
                count++;
            }
            minrow++;
            
            //right
            for(int i = minrow, j = maxcol; i<=maxrow && count<elts; i++){
                ls.add(matrix[i][j]);
                count++;
            }
            maxcol--;
            
            //bottom
            for(int i = maxrow, j = maxcol; j>=mincol && count<elts; j--){
                ls.add(matrix[i][j]);
                count++;
            }
            maxrow--;
            
            //left
            for(int i = maxrow, j = mincol; i>=minrow && count<elts; i--){
                ls.add(matrix[i][j]);
                count++;
            }
            mincol++;
        }
        return ls;
    }
}
//https://www.youtube.com/watch?v=SVFXEqn3Ceo