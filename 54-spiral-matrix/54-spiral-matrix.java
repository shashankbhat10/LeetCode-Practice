class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int count = 0;
        int m = matrix.length;
        int n = matrix[0].length;
        
        List<Integer> result = new ArrayList<>();
        
        int top = 0;
        int bottom = matrix.length;
        int left = 0;
        int right = matrix[0].length;
        
        while(count < m*n){
            // Add left to right
            for(int i=left; i<right && count < m*n; i++){
                result.add(matrix[top][i]);
                count++;
            }
            
            top++;
            // Add top to bottom
            for(int i=top; i<bottom && count < m*n; i++){
                result.add(matrix[i][right-1]);
                count++;
            }
            
            right--;
            // Add right to left
            for(int i=right-1; i>=left && count < m*n; i--){
                result.add(matrix[bottom-1][i]);
                count++;
            }
            
            bottom--;
            // Add bottom to top
            for(int i=bottom-1; i>=top && count < m*n; i--){
                result.add(matrix[i][left]);
                count++;
            }
            left++;
            
            System.out.println("count" + count);
            System.out.println("total" + m*n);
        }
        
        return result;
    }
}