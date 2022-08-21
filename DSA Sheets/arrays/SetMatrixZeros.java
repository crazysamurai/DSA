class Solution {
    public void setZeroes(int[][] matrix) {
        boolean rowFlag = false; //treat it as an extra column which will be used to set the columns zero at last
        //traverse through the matrix and set the first cols and rows as zeros of the cells that are zeros
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[0][j] = 0;
                    if(i>0){
                        matrix[i][0] = 0;
                    }else{
                        rowFlag = true;
                    }
                }
            }
        }
    //traverse through the matrix and set the cells 0 where either first col is 0 or 1st row is 0,  don't traverse the 0th col and row    
        for(int i = 1; i<matrix.length; i++){
            for(int j = 1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int i = 0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
        if(rowFlag){
            for(int j = 0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        
    }
    
}