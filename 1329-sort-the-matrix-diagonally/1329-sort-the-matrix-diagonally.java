class Solution {
    public int[][] diagonalSort(int[][] mat) {
        int diagStartRow = mat.length-1;
        int diagStartCol = 0;
        int m = mat.length;
        int n = mat[0].length;
        
        int numDiags = 0;
        if(m == 1 && n == 1)
            numDiags = 1;
        else
            numDiags = m + n - 1;
        
        while(diagStartCol < n){
            List<Integer> diag = new ArrayList<Integer>();
            
            int i = diagStartRow;
            int j = diagStartCol;
            
            int totalEls = 0;
            while(i < m && j < n){
                diag.add(mat[i++][j++]);
                totalEls++;
            }
            
            Collections.sort(diag);
            
            i = diagStartRow;
            j = diagStartCol;
            
            int in = 0;
            while(in < totalEls){
                mat[i++][j++] = diag.get(in++);
            }
            
            if(diagStartRow == 0)
                diagStartCol++;
            else{
                diagStartRow--;
            }
        }
        
        return mat;
    }
}