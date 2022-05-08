class Solution {
    public void setZeroes(int[][] matrix) {
//         boolean f_col = false;
        
//         for(int i=0; i<matrix.length; i++){
//             if(matrix[i][0] == 0)
//                 f_col = true;
            
//             for(int j = 1; j < matrix[0].length; j++){
//                 if(matrix[i][j] == 0){
//                     matrix[i][0] = 0;
//                     matrix[0][j] = 0;
//                 }
//             }
//         }
        
//         for(int i=1; i<matrix.length; i++){
//             for(int j=1; j<matrix[0].length; j++){
//                 if(matrix[i][0] == 0 || matrix[0][j] == 0)
//                     matrix[i][j] = 0;
//             }
//         }
        
//         if(matrix[0][0] == 0){
//             for(int j=0; j<matrix[0].length; j++){
//                 matrix[0][j] = 0;
//             }
//         }
        
//         if(f_col){
//             for(int i=0; i<matrix.length; i++){
//                 matrix[i][0] = 0;
//             }
//         }
        
        boolean firstColumn = false;
        for(int i=0; i<matrix.length; i++){
            if(matrix[i][0] == 0)
                firstColumn = true;
            
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i=1; i<matrix.length; i++){
            for(int j=1; j<matrix[0].length; j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }
        
        if(matrix[0][0] == 0){
            for(int j=0; j<matrix[0].length; j++){
                matrix[0][j] = 0;
            }
        }
        
        if(firstColumn){
            for(int i=0; i<matrix.length; i++){
                matrix[i][0] = 0;
            }
        }
        
    }
}